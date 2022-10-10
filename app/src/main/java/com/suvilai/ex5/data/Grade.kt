package com.suvilai.ex5.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**     Suvi Laitinen, 10.10.2022
 *      2113710
 *
 *      Data class for GradeDatabase
 */

@Entity(tableName = "grade_table")
data class Grade (
    @PrimaryKey
    val hetekaId: Int,
    val grade: Int = 0
)

