package com.revature.isuckatretrofit.data.model

import com.google.gson.annotations.SerializedName

data class Donation(
//    @SerializedName("id")
//    val id: Int,

    @SerializedName("publisher")
    val publisher: String,

    @SerializedName("donation")
    val donationName: String,

    @SerializedName("location")
    val location: String,

    @SerializedName("published_at")
    val time: String,

    @SerializedName("type")
    val description: String,

    @SerializedName("tags")
    val tags: List<String>,

    @SerializedName("images")
    val images: List<String>
)