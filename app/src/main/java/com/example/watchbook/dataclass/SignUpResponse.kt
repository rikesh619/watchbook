package com.example.watchbook.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @get:SerializedName("user_id")
    var user_id : Int?=null,
    @SerializedName("email")
    var email : String?=null,
    @SerializedName("password")
    var password : String?=null
)