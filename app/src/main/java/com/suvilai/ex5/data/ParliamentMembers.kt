package com.suvilai.ex5.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**     Suvi Laitinen, 8.10.2022
 *      2113710
 *
 *      Data class for parliament members
 */


@Parcelize
@Entity
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
) : Parcelable


