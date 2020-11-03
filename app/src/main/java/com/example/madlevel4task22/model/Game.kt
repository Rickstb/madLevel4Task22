package com.example.madlevel4task22.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Gametable")
data class Game(

    @ColumnInfo(name = "date")
    var datePlayed: Date?,

    @ColumnInfo(name = "pcMove")
    var pcMove: Int,

    @ColumnInfo(name = "playerMove")
    var playerMove: Int,

    @ColumnInfo(name = "result")
    var result: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
)