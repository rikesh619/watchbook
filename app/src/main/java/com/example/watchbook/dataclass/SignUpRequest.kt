package com.example.watchbook.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("email")
    var email : String ,
    @SerializedName("password")
    var password : String,
    @SerializedName("username")
    var username : String ,
    @SerializedName("phone")
    var phone : Int
)
