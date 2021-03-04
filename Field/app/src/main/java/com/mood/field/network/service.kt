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

private const val BASE_URL = "https://gist.githubusercontent.com/moodfactor/d14fc3e764d00959090528faa737162e/raw/3842592baacd6855bd05e93cb0e0b565386e5420/"

interface MarketService {

    @GET("markets")
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
