package com.example.watchbook.client

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val URL = "http://localhost:3000/"
    private val interceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
    val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(URL).client(
        okHttpClient).build()

    fun <T> buildService(serviceType: Class <T>) : T {

        return retrofit.create(serviceType)
    }


}