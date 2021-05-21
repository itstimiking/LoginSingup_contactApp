package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.contactapp.databinding.ActivityLoginBinding
import com.example.contactapp.db.UserRepository

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var userRepo: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signinButton.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser(){
        userRepo = UserRepository(this)

        val email = binding.email.text.toString()
        val password = binding.password.text.toString()

        val user = userRepo.findUser(email,password)
        if(user == null){
            Toast.makeText(this, "Wrong Details - Check your details", Toast.LENGTH_LONG).show()
        }else if (user.email.isNotEmpty()){
            Toast.makeText(this, "User exist", Toast.LENGTH_LONG).show()
        }else {
            Log.v(
                "LOGIN LOGS",
                "################# ************ USER LOGIN ISSUES ************############ $user"
            )
        }
    }
}