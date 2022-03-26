package com.revature.retrofitexample.network.repository

import com.revature.retrofitexample.network.Login
import com.revature.retrofitexample.network.Token
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPIService {

    @POST("auth")
    suspend fun getLogin(@Body login: Login): Response<Token>
}