package com.example.watchbook.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("email")
    var email : String? = null,
    @SerializedName("password")
    var password : String?=null,
    @SerializedName("username")
    var username : String?= null
)
