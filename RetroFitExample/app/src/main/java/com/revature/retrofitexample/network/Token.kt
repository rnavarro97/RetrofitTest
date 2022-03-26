package com.revature.retrofitexample.network

import com.google.gson.annotations.SerializedName

data class Token (
    @SerializedName("accessToken") val accessToken: String

        ){

}