package com.revature.isuckatretrofit.data.model

import com.google.gson.annotations.SerializedName

data class DonationResponse (

    @SerializedName("DonationList")
        var donationList: List<Donation>

)