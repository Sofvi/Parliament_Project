package com.suvilai.ex5.data

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.android.parcel.Parcelize


@Dao
interface MemberDao {

    @Query("SELECT * FROM ParliamentMembers ORDER BY lastname")
    fun getMembers() : LiveData<List<ParliamentMembers>>
}