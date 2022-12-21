package com.example.watchbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.WindowDecorActionBar
import androidx.recyclerview.widget.RecyclerView
import com.example.watchbook.databinding.ActivityMainBinding
import com.example.watchbook.dataclass.SignUpResponse
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textCreateAccount.setOnClickListener {
            startActivity(Intent(this , SignupActivity :: class.java))
        }


    }

    fun signupRegister(){

    }
}