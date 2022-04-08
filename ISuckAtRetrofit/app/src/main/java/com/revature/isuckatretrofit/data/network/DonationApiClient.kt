package com.revature.isuckatretrofit.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DonationApiClient {

    private const val BASE_URL="https://private-15a842-new4u.apiary-mock.com/"

    private val retrofit= Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    val service:DonationApi by lazy {

        retrofit.build().create(DonationApi::class.java)

    }
}