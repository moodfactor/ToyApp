package com.mood.field.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// Since we only have one service, this can all go in one file.
// If you add more services, split this to multiple files and make sure to share the retrofit
// object between services.

/**
 * A retrofit service to fetch a market list.
 */

private const val BASE_URL = "https://gist.githubusercontent.com/moodfactor/f0ec7b3e6cd4fc42a98380a4c55ae876/raw/7c4e30d8e0d01c510bf43e229f7f2aea08319ede/"

interface MarketService {

    @GET("toys")
    suspend fun getMarketItems(): NetworkMarketContainer
}

/**
 * Main entry point for network access. Call like `MarketNetwork.markets.getMarketItems()`
 */
object MarketNetwork {

    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val markets = retrofit.create(
        MarketService::class.java)

}
