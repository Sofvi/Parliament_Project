package com.suvilai.ex5.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

/**     Suvi Laitinen, 8.10.2022
 *      2113710
 *
 *      RoomDB class for the database.
 */


@Database(entities = [ParliamentMembers::class, Grade::class], version = 2, exportSchema = false)
abstract class MemberDatabase : RoomDatabase() {

    abstract fun memberDao() : MemberDao

    companion object {
        @Volatile
        private var INSTANCE: MemberDatabase? = null

        fun getInstance(context: Context): MemberDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MemberDatabase::class.java,
                    "member_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}