package com.example.contactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.contactapp.databinding.ActivitySignupBinding
import com.example.contactapp.db.UserRepository
import com.example.contactapp.db.UserViewModel
import com.example.contactapp.db.entity.UserData

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.signupButton.setOnClickListener {
            addDetails()
        }

        binding.loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addDetails(){

        val email = binding.email.text.toString()
        val password = binding.password.text.toString()

        val user = UserData(
            email = email,
            password = password
        )
        viewModel.addUser(this,user)
    }
}