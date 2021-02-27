package com.example.toyapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ToyDatabaseDao {

    @Insert
    suspend fun insert(toy: Toy)

    @Update
    suspend fun update(toy: Toy)

    @Query("SELECT * FROM toys_table WHERE toyId = :key")
    suspend fun get(key: Int): Toy?

    @Query("DELETE FROM toys_table")
    suspend fun clear()

    @Query("SELECT * FROM toys_table ORDER BY toyId DESC LIMIT 1")
    suspend fun getRecentToy(): Toy?


    @Query("SELECT * FROM toys_table ORDER BY toyId DESC")
    fun getAllToys(): LiveData<List<Toy>>
}