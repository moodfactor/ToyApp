package com.example.toyapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Toy::class], version = 1, exportSchema = false)
abstract class ToyDatabase: RoomDatabase() {

    abstract val toyDatabaseDao: ToyDatabaseDao


    companion object {

        @Volatile
        private var INSTANCE: ToyDatabase? = null

        fun getInstance(context: Context): ToyDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ToyDatabase::class.java,
                        "toysDatabase"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}