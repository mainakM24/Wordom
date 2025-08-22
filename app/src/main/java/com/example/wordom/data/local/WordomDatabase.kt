package com.example.wordom.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.wordom.data.local.dao.WordDao
import com.example.wordom.data.local.models.WordEntity
import kotlin.concurrent.Volatile

@Database(
    entities = [WordEntity::class],
    version = 1
)
abstract class WordomDatabase : RoomDatabase() {
    abstract fun getWordDao() : WordDao

    companion object {
        @Volatile
        private var Instance : WordomDatabase? = null

        fun getDataBase(context: Context) : WordomDatabase {
            return Instance ?:synchronized(this) {
                Room.databaseBuilder(context, WordomDatabase::class.java, "wordom_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}