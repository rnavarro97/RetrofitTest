package com.revature.isuckatretrofit.data.repository

import android.util.Log
import com.revature.isuckatretrofit.data.model.Donation
import com.revature.isuckatretrofit.data.network.DonationApi

class DonationRepository (val donationApi: DonationApi) {

    sealed class Result
    {
        object LOADING: Result()
        data class Success (val donationList: List<Donation>): Result()
        data class Failure (val throwable: Throwable): Result()
    }

    suspend fun fetchDonations(): Result
    {

        return try {

            val donationList = donationApi.fetchDonationList().donationList
            Log.d("DonationList","$donationList")
            Log.d("DonationSize","Success"+donationList.size)
            Result.Success(donationList = donationList)
        }catch (exception: Exception)
        {
            Log.d("DonationList","Failure")
            Result.Failure(exception)
        }
    }

}