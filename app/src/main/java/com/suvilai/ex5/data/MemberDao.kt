package com.suvilai.ex5.data

import androidx.lifecycle.LiveData
import androidx.room.*

/**     Suvi Laitinen, 8.10.2022
 *      2113710
 *
 *      Dao interface. Contains SQL-calls.
 */


@Dao
interface MemberDao {

    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    //suspend fun addMember(member : ParliamentMembers)

    @Query("SELECT * FROM ParliamentMembers")
    fun getMembers() : LiveData<List<ParliamentMembers>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: ParliamentMembers)

    //@Query("SELECT * FROM ParliamentMembers WHERE party")
    //fun getParty(party: String): LiveData<List<ParliamentMembers>>

    //Grade
    /*
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGrade(grade: Grade)

    @Update
    suspend fun updateGrade(grade: Grade)

    @Query("SELECT GRADE(*) FROM Grade")
    suspend fun getGrade() : Int

    @Query("SELECT * FROM Grade WHERE personId like :personId")
    fun getCurrentGrade(personId: Int): LiveData<Grade>

    @Query("SELECT * FROM Grade WHERE personId like :personId")
    suspend fun getGradeasGrade(personId: Int): Grade

     */
}