package com.example.contactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactapp.databinding.ActivitySignupBinding
import com.example.contactapp.db.UserRepository
import com.example.contactapp.db.entity.UserData

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var userRepo: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupButton.setOnClickListener {
            addDetails()
        }

        binding.loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addDetails(){
        userRepo = UserRepository(this)

        val email = binding.email.text.toString()
        val password = binding.password.text.toString()
        val btn = binding.signupButton

        val user = UserData(email = email, password = password)

        try {
            userRepo.insertUser(user)
            btn.isEnabled = false
            Toast.makeText(this, "$email : user has been added", Toast.LENGTH_SHORT).show()
        }catch (e: Exception){
            Toast.makeText(this, "Error adding user: $email", Toast.LENGTH_SHORT).show()
        }
    }
}