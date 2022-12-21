package com.example.watchbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.WindowDecorActionBar
import androidx.recyclerview.widget.RecyclerView
import com.example.watchbook.client.ApiClient
import com.example.watchbook.databinding.ActivityMainBinding
import com.example.watchbook.dataclass.LoginRequest
import com.example.watchbook.dataclass.LoginResponse
import com.example.watchbook.dataclass.SignUpResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.coroutines.Dispatchers.Main
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textCreateAccount.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        btn_sign_in.setOnClickListener {
            if (TextUtils.isEmpty(email.text.toString())) {
                val message: String = "Please enter the  Email"
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty(password.text.toString())) {
                val message: String = "Please enter the  Password"
                Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
            } else {
                val loginRequest : LoginRequest = LoginRequest()
                loginRequest.email = email.text.toString()
                loginRequest.password = password.text.toString()

                loginUser(loginRequest)

            }
        }


    }

    fun loginUser(loginRequest: LoginRequest) {

        val loginResponseCall: Call<LoginResponse> =
            ApiClient.buildService(InterfaceWatchBook::class.java).loginUser(loginRequest)
        loginResponseCall.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse : LoginResponse = response.body()!!
                    startActivity(Intent(this@MainActivity , AfterLoginActivity::class.java))
                    finish()

                } else {
                    val message: String = "Error Occured Please Try Again Later..."
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                val message: String = t.localizedMessage as String
                Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}