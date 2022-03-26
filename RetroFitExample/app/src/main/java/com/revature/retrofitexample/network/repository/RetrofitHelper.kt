package com.revature.retrofitexample.network.repository

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.revature.retrofitexample.network.Login
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {

    private val retrofit: Retrofit

    init {


        val builder = Retrofit.Builder()
            .baseUrl("https://tasks-planner-api.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .writeTimeout(0,
            TimeUnit.MICROSECONDS)
            .writeTimeout(2,TimeUnit.MINUTES)
            .writeTimeout(1,TimeUnit.MINUTES).build()

        retrofit = builder.client(okHttpClient).build()
    }

    fun getAuthService():AuthAPIService{
        return retrofit.create(AuthAPIService::class.java)
    }
}