package com.example.wordom.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourites")
data class WordEntity(
    @PrimaryKey(autoGenerate = false)
    var date : String,
    var name : String,
    var definition : String,
    var partsOfSpeech : String
)
