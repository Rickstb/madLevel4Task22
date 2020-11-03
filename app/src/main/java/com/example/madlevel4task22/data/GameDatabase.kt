package com.example.madlevel4task22.data

import android.content.Context
import androidx.room.*
import com.example.madlevel4task22.model.Game
import com.example.madlevel4task22.utils.Converters

@TypeConverters(Converters::class)
@Database(version = 1, entities = [Game::class])
abstract class GameDatabase : RoomDatabase() {
    abstract fun getGameDao(): GameDao

    companion object {
        @Volatile
        private var database: GameDatabase? = null

        fun getDatabase(context: Context): GameDatabase? {
            if (database == null) {
                synchronized(GameDatabase) {
                    if (database == null) {
                        database =
                            Room.databaseBuilder(context, GameDatabase::class.java, "GameDatabase")
                                .build()
                    }
                }
            }
            return database
        }
    }

}