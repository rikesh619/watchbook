package com.example.watchbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.watchbook.client.ApiClient
import com.example.watchbook.dataclass.SignUpRequest
import com.example.watchbook.dataclass.SignUpResponse
import kotlinx.android.synthetic.main.activity_signup.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.sign

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        backspace.setOnClickListener {
            onBackPressed()
        }

        textSignIn.setOnClickListener {
            onBackPressed()
        }

        btn_create_acc.setOnClickListener {
           val  signupRequest : SignUpRequest




            signupUser(signupRequest)
        }

    }

    fun signupUser(signUpRequest: SignUpRequest){

       val  signUpRequestCall :Call<SignUpResponse> = ApiClient.buildService(InterfaceWatchBook :: class.java).signupUser(signUpRequest)
       signUpRequestCall.enqueue(object : Callback<SignUpResponse>{
           override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {

               if (response.isSuccessful){


                   startActivity(Intent(this@SignupActivity , MainActivity::class.java))

               }else{
                   val message: String = "Error Occured Please Try Again Later..."
                   Toast.makeText(this@SignupActivity , message, Toast.LENGTH_SHORT).show()
               }
           }

           override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
               val message: String = t.localizedMessage
               Toast.makeText(this@SignupActivity , message, Toast.LENGTH_SHORT).show()
           }

       })
    }
}