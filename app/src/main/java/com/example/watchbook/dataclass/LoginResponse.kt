package com.example.watchbook.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("user_id")
    var user_id : Int? = null ,
    @SerializedName("email")
    @Expose
    var email : String? = null ,
    @SerializedName("password")
    @Expose
    var password : String? = null
)
