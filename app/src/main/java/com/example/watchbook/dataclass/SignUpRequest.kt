package com.example.watchbook.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("email")
    var email : String ,
    @SerializedName("password")
    val password : String,
    @SerializedName("username")
    val username : String ,
    @SerializedName("phone")
    val phone : Int
)
