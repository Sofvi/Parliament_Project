package com.suvilai.ex5.data

import androidx.lifecycle.LiveData
import androidx.room.*

/**     Suvi Laitinen, 10.10.2022
 *      2113710
 *
 *      GradeDao interface. Contains SQL-calls.
 */

@Dao
interface GradeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGrade(grade: Grade)

    @Update
    fun updateGrade(grade: Grade)

    @Query("SELECT * FROM grade_table WHERE hetekaId LIKE :hetekaId")
    fun getCurrentGrade(hetekaId: Int) : LiveData<Grade>
}

