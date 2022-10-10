package com.suvilai.ex5.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**     Suvi Laitinen, 10.10.2022
 *      2113710
 *
 *      RoomDB for CommentDatabase.
 */

@Database(entities = [Comment::class], version = 1, exportSchema = false)
abstract class CommentDatabase : RoomDatabase() {

    abstract fun commentDao() : CommentDao

    companion object {
        @Volatile
        private var INSTANCE: CommentDatabase? = null

        fun getInstance(context: Context): CommentDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CommentDatabase::class.java,
                    "comment_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}