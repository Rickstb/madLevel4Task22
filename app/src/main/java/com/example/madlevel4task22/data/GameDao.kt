package com.example.madlevel4task22.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.madlevel4task22.model.Game

@Dao
interface GameDao {
    @Query("SELECT * FROM Gametable")
    suspend fun getAllGames(): List<Game>

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("DELETE FROM Gametable")
    suspend fun deleteAllGames()

    @Query("SELECT COUNT(*) FROM Gametable where result = :result")
    suspend fun getCountDynamic(result: String): Int
}