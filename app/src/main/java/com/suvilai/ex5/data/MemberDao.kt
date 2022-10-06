package com.suvilai.ex5.data

import androidx.room.Dao
import retrofit2.http.Query


@Dao
interface MemberDao {

    @Query("SELECT * FROM member_table order by firstname")
    fun getMembers() : List<ParliamentMembers>
}