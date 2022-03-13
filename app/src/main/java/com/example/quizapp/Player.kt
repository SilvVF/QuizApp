package com.example.quizapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "playerName") val playerName: String = "",
    @ColumnInfo(name = "score") val score: Int = 0,
)
