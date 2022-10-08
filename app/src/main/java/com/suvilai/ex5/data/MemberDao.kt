package com.suvilai.ex5.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**     Suvi Laitinen, 8.10.2022
 *      2113710
 *
 *      Dao interface. Contains SQL-calls.
 */


@Dao
interface MemberDao {

    @Query("SELECT * FROM ParliamentMembers")
    fun getMembers() : LiveData<List<ParliamentMembers>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: ParliamentMembers)

    //@Query("SELECT * FROM ParliamentMembers WHERE party")
    //fun getParty(party: String): LiveData<List<ParliamentMembers>>
}