package com.revature.isuckatretrofit.data.network

import com.revature.isuckatretrofit.data.model.DonationResponse
import retrofit2.http.GET

interface DonationApi {

        @GET("donations")
        suspend fun fetchDonationList(): DonationResponse

}