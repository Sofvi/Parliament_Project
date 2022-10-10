package com.suvilai.ex5.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**     Suvi Laitinen, 10.10.2022
 *      2113710
 *
 *      Data class for CommentDatabase
 */

@Entity(tableName = "comment_table")
data class Comment (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val hetekaId : Int,
    val comment : String
)