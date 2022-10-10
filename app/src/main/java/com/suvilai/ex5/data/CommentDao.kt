package com.suvilai.ex5.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**     Suvi Laitinen, 10.10.2022
 *      2113710
 *
 *      CommentDao interface. Contains SQL-calls.
 */

@Dao
interface CommentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addComment(comment: Comment)

    @Query("SELECT * FROM comment_table")
    fun readComments(): LiveData<List<Comment>>

}