package com.suvilai.ex5.repository

import com.suvilai.ex5.data.Comment
import com.suvilai.ex5.data.CommentDao

/**     Suvi Laitinen, 10.10.2022
 *      2113710
 *
 *      Repository for the Comment -table in Room
 */

class CommentRepository(private val commentDao: CommentDao) {

    fun addComment(comment: Comment) = commentDao.addComment(comment)
}

