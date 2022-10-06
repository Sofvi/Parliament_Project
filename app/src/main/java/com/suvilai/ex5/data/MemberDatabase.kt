package com.suvilai.ex5.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.suvilai.ex5.MyApp
import kotlinx.coroutines.CoroutineScope

@Database(entities = [ParliamentMembers::class], version = 1, exportSchema = false)
abstract class MemberDatabase : RoomDatabase() {
    abstract fun memberDao() : MemberDao
    companion object {
        @Volatile
        private var INSTANCE: MemberDatabase? = null
        fun getInstance(context: Context, scope: CoroutineScope): MemberDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MemberDatabase::class.java, "member_database"
                    )
                        .fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }
}