package com.example.watchbook

import com.example.watchbook.dataclass.LoginRequest
import com.example.watchbook.dataclass.LoginResponse
import com.example.watchbook.dataclass.SignUpRequest
import com.example.watchbook.dataclass.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface InterfaceWatchBook {
    @POST("authenticate")
    fun loginUser(@Body loginRequest: LoginRequest) : Call<LoginResponse>

    @POST("user")
    fun signupUser(@Body signUpRequest: SignUpRequest) : Call<SignUpResponse>
}