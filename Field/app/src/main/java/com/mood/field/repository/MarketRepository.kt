package com.mood.field.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.mood.field.database.MarketDatabase
import com.mood.field.database.asDomainModel
import com.mood.field.domain.Market
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.mood.field.network.MarketNetwork
import com.mood.field.network.asDatabaseModel
import timber.log.Timber

class MarketRepository(val database: MarketDatabase) {

    val markets : LiveData<List<Market>> = Transformations.map(database.marketDao.getMarket()){
        it.asDomainModel()
    }

    /**
     * Refresh the videos stored in the offline cache.
     *
     * This function uses the IO dispatcher to ensure the database insert database operation
     * happens on the IO dispatcher. By switching to the IO dispatcher using `withContext` this
     * function is now safe to call from any thread including the Main thread.
     *
     */
    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            Timber.d("refresh videos is called");
            val marketList = MarketNetwork.markets.getMarketItems()
            database.marketDao.insertAll(marketList.asDatabaseModel())
        }
    }

}