package com.example.toyapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.toyapp.R

@Entity(tableName = "toys_table")
data class Toy(
    @PrimaryKey(autoGenerate = true)
    val toyId: Int,
    @ColumnInfo(defaultValue = "Bee")
    val title: String = "Bee",
    @ColumnInfo(defaultValue = "a toy")
    val description: String = "a toy",
    @ColumnInfo(defaultValue = "")
    val image: Int = R.drawable.ic_baseline_emoji_emotions_24
)