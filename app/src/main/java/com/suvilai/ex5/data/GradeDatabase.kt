package com.suvilai.ex5.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**     Suvi Laitinen, 9.10.2022
 *      2113710
 *
 *      RoomDB for GradeDatabase.
 */

@Database(entities = [Grade::class], version = 1, exportSchema = false)
abstract class GradeDatabase : RoomDatabase() {

    abstract fun gradeDao(): GradeDao

    companion object {

        @Volatile
        private var INSTANCE: GradeDatabase? = null

        fun getInstance(context: Context): GradeDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GradeDatabase::class.java,
                        "grade_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}

