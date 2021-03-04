package com.mood.field.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mood.field.domain.Market


/**
 * Database entities go in this file. These are responsible for reading and writing from the
 * database.
 */


/**
 * DatabaseMarket represents a Market entity in the database.
 */

@Entity(tableName = "DatabaseMarket")
data class DatabaseMarket constructor(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val price: String,
    val imgUrl: String
)

/**
 * Map DatabaseMarket to domain entities
 */
fun List<DatabaseMarket>.asDomainModel(): List<Market> {
    return map {
        Market(
            id = it.id,
            title = it.title,
            description = it.description,
            price = it.price,
            imgUrl = it.imgUrl
        )
    }
}