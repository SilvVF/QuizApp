package com.example.quizapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.quizapp.data.models.Player
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Query("SELECT * FROM player")
    fun fetchAll(): Flow<List<Player>>

    @Insert
    suspend fun insert(player: Player)

    @Delete
    suspend fun delete(player: Player)

}