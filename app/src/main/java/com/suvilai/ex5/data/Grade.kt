package com.suvilai.ex5.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "grade_table")
data class Grade (
    @PrimaryKey
    val personId: Int,
    val grade: Int
)