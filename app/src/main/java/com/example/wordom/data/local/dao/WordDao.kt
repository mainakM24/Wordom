package com.example.wordom.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.wordom.data.local.models.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Insert(onConflict = IGNORE)
    suspend fun insertWord(word: WordEntity)

    @Delete
    suspend fun deleteWord(word : WordEntity)

    @Query("SELECT * FROM favourites")
    fun getAllWord() : Flow<List<WordEntity>>

}