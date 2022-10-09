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


    //Member

    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    //suspend fun addMember(member : ParliamentMembers)

    @Query("SELECT * FROM ParliamentMembers")
    fun getMembers() : LiveData<List<ParliamentMembers>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: ParliamentMembers)

    //@Query("SELECT * FROM ParliamentMembers WHERE party")
    //fun getParty(party: String): LiveData<List<ParliamentMembers>>


    //Grade

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGrade(grade: Grade)

    @Update
    fun updateGrade(grade: Grade)

    @Query("SELECT COUNT(*) FROM grade_table")
    fun getGradeCount() : Int

   // @Query("SELECT * FROM grade_table WHERE personId like :personId")
    //fun getCurrentGrade(personId: Int): LiveData<Grade>

    //@Query("SELECT * FROM grade_table WHERE personId like :personId")
    //fun getGradeAsGrade(personId: Int): Grade

}