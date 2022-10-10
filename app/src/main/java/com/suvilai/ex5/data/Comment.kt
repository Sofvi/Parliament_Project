package com.suvilai.ex5.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comment_table")
data class Comment (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val personId : Int,
    val content : String
)