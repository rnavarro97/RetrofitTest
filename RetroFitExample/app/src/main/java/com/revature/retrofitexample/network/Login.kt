package com.revature.retrofitexample.network

import com.google.gson.annotations.SerializedName

data class Login (
    @SerializedName("email") val email:String,
    @SerializedName("password") val password:String
)
{
//    "email":"mayur@gmail.com"
//    "password":"password"
}