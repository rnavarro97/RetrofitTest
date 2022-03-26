package com.revature.retrofitexample.viewmodel

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.retrofitexample.network.Login
import com.revature.retrofitexample.network.repository.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val loginRequestLiveData = MutableLiveData<Boolean>()

    //We are sending this
    fun login(email: String, password: String) {

        viewModelScope.launch(Dispatchers.IO){

            try {

                val authService = RetrofitHelper.getAuthService()

                val responseService = authService.getLogin(Login(email = email, password = password))

                if(responseService.isSuccessful)
                {
                    responseService.body()?.let{ token ->

                        Log.d("logging","Response Token $token")
                    }
                }
                else
                {

                    responseService.errorBody()?.let { error ->

                        Log.d("logging","Response Token $error")

                        error.close()

                    }

                }

            }
            catch (e: Exception)
            {

            }

        }

    }
}