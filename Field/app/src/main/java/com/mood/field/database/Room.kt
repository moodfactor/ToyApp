package com.mood.field.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MarketDao {

    @Query("SELECT * FROM DatabaseMarket")
    fun getMarket(): LiveData<List<DatabaseMarket>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(markets: List<DatabaseMarket>)
}

@Database(entities = [DatabaseMarket::class], version = 7, exportSchema = false)
abstract class MarketDatabase: RoomDatabase() {
    abstract val marketDao: MarketDao
}

private lateinit var INSTANCE: MarketDatabase

fun getDatabase(context: Context): MarketDatabase {
    synchronized(MarketDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                MarketDatabase::class.java,
                "markets").fallbackToDestructiveMigration().build()
        }
    }
    return INSTANCE
}