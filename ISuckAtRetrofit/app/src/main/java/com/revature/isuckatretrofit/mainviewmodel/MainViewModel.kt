package com.revature.isuckatretrofit.mainviewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.revature.isuckatretrofit.data.model.Donation
import com.revature.isuckatretrofit.data.network.DonationApiClient
import com.revature.isuckatretrofit.data.repository.DonationRepository
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val donationService = DonationApiClient.service
    private lateinit var repository:DonationRepository

    var donationList: List<Donation> by mutableStateOf(listOf())

    lateinit var clickedItem: Donation

    init{

        fetchDonations()
    }

    private fun fetchDonations()
    {

        repository = DonationRepository(donationService)
        viewModelScope.launch {
            var response = repository.fetchDonations()
            Log.d("DonationResponse","$response")

            when (response){

                is DonationRepository.Result.Success -> {

                    Log.d("Donation","Success")
                    donationList = response.donationList
                }
                is DonationRepository.Result.Failure ->
                {
                    Log.d("MainViewModel","Failure")
                }
            }

        }
    }
}