package com.suvilai.ex5.data

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.android.parcel.Parcelize


@Dao
interface MemberDao {

    @Query("SELECT * FROM ParliamentMembers")
    fun getMembers() : LiveData<List<ParliamentMembers>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: ParliamentMembers)

    //@Query("SELECT * FROM ParliamentMembers WHERE party")
    //fun getParty(party: String): LiveData<List<ParliamentMembers>>
}