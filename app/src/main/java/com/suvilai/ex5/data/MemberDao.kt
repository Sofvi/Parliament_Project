package com.suvilai.ex5.data

import androidx.lifecycle.LiveData
import androidx.room.*

/**     Suvi Laitinen, 8.10.2022
 *      2113710
 *
 *      MemberDao interface. Contains SQL-calls.
 */

@Dao
interface MemberDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: ParliamentMembers)

    @Query("SELECT * FROM ParliamentMembers")
    fun getMembers() : LiveData<List<ParliamentMembers>>
}