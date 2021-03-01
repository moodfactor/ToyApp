package com.mood.field.network

import com.squareup.moshi.JsonClass
import com.mood.field.database.DatabaseMarket
import com.mood.field.domain.Market


/**
 * DataTransferObjects go in this file. These are responsible for parsing responses from the server
 * or formatting objects to send to the server. You should convert these to domain objects before
 * using them.
 *
 * @see domain package for
 */

/**
 * MarketHolder holds a list of Markets.
 *
 * This is to parse first level of our network result which looks like
 *
 * {
 *   "videos": []
 * }
 */
@JsonClass(generateAdapter = true)
data class NetworkMarketContainer(val markets: List<NetworkMarket>)

/**
 * Videos represent a devbyte that can be played.
 */
@JsonClass(generateAdapter = true)
data class NetworkMarket(
    val id: String,
    val title: String,
    val description: String,
    val price: Int,
    val imgUrl: String)

/**
 * Convert Network results to database objects
 */
fun NetworkMarketContainer.asDomainModel(): List<Market> {
    return markets.map {
        Market(
            id = it.id,
            title = it.title,
            description = it.description,
            price = it.price,
            imgUrl = it.imgUrl
        )
    }
}


/**
 * Convert Network results to database objects
 */
fun NetworkMarketContainer.asDatabaseModel(): List<DatabaseMarket> {
    return markets.map {
        DatabaseMarket(
            id = it.id,
            title = it.title,
            description = it.description,
            price = it.price,
            imgUrl = it.imgUrl
        )
    }
}