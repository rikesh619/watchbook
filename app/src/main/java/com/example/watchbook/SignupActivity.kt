package com.example.watchbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
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
            if (TextUtils.isEmpty(sign_up_email.text.toString()) || TextUtils.isEmpty(sign_up_password.text.toString()) || TextUtils.isEmpty(sign_up_username.text.toString()) || TextUtils.isEmpty(sign_up_password_confirm.text.toString())){
                val message: String = "All Blank Spots Need to be Filled.."
                Toast.makeText(this@SignupActivity , message, Toast.LENGTH_SHORT).show()
            }
            val signupRequest : SignUpRequest = SignUpRequest()
           signupRequest.email = sign_up_email.text.toString()
            signupRequest.password = sign_up_password.text.toString()
            signupRequest.username = sign_up_username.text.toString()
            signupRequest.password = sign_up_password_confirm.text.toString()


            signupUser(signupRequest)
        }

    }

    fun signupUser(signUpRequest: SignUpRequest){

       val  signUpResponseCall :Call<SignUpResponse> = ApiClient.buildService(InterfaceWatchBook :: class.java).signupUser(signUpRequest)
       signUpResponseCall.enqueue(object : Callback<SignUpResponse>{
           override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {

               if (response.isSuccessful){
                   val message: String = "Successfull ...."
                   Toast.makeText(this@SignupActivity , message, Toast.LENGTH_SHORT).show()
                   startActivity(Intent(this@SignupActivity , MainActivity::class.java))

               }else{
                   val message: String = "Error Occured Please Try Again Later..."
                   Toast.makeText(this@SignupActivity , message, Toast.LENGTH_SHORT).show()
               }
           }

           override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
               val message: String = t.localizedMessage as String
               Toast.makeText(this@SignupActivity , message, Toast.LENGTH_SHORT).show()
           }

       })
    }
}