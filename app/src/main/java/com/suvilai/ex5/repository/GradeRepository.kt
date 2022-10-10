package com.suvilai.ex5.repository

import com.suvilai.ex5.data.Grade
import com.suvilai.ex5.data.GradeDao

/**     Suvi Laitinen, 10.10.2022
 *      2113710
 *
 *      Repository class for the Grade -table in RoomDB
 */

class GradeRepository(private val gradeDao: GradeDao) {

    fun updateGrade(grade: Grade) = gradeDao.updateGrade(grade)

    fun getCurrentGrade(hetekaId: Int) = gradeDao.getCurrentGrade(hetekaId)
}



