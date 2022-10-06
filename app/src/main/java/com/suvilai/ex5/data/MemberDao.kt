package com.suvilai.ex5.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query


@Dao
interface MemberDao {

    @Query("SELECT * FROM member_table order by lastname")
    fun getMembers() : LiveData<List<ParliamentMembers>>
}