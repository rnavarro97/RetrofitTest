package com.revature.jetcomposefirstsample

import android.os.Parcelable
import java.time.LocalDateTime
import kotlinx.parcelize.Parcelize
import java.time.ZoneId

@Parcelize
class User(

    val name:String,
    val id:String,
    val created: LocalDateTime
    ):Parcelable
