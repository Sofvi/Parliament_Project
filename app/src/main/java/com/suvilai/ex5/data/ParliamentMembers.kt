package com.suvilai.ex5.data

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Parcelize
@Entity(tableName = "member_table")
data class ParliamentMembers(
    @PrimaryKey
    val hetekaId: Int,
    val seatNumber: Int = 0,
    val lastname: String,
    val firstname: String,
    val party: String,
    val minister: Boolean = false,
    val pictureUrl: String = "",
    var fullname: String = "$firstname $lastname"
) //: Parcelable