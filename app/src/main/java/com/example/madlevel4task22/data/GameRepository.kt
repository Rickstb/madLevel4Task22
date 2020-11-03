package com.example.madlevel4task22.data

import android.content.Context
import com.example.madlevel4task22.model.Game

class GameRepository(context: Context) {
    private var gamedao = GameDatabase.getDatabase(context)?.getGameDao()

    suspend fun getAllGames(): List<Game>? {
        return gamedao?.getAllGames()
    }

    suspend fun insertGame(game: Game) {
        gamedao?.insertGame(game)
    }

    suspend fun deleteGame(game: Game) {
        gamedao?.deleteGame(game)
    }

    suspend fun deleteAllGames() {
        gamedao?.deleteAllGames()
    }

    suspend fun getCountDynamic(result: String): Int? {
        return gamedao?.getCountDynamic(result)
    }
}