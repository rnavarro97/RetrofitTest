package com.revature.roomdbexample.datamodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer")
data class Customer(
    /*
    This is to generate keys (not foreign). You do not need to give this one
    the same name as the value below.
     */
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @ColumnInfo(name = "gender")
    val gender: String? = null,

    @ColumnInfo(name = "email_id")
    val emailID: String? = null,
)