package com.example.watchbook.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @get:SerializedName("user_id")
    val user_id : Int,
    @SerializedName("email")
    val email : String,
    @SerializedName("password")
    val password : String
)