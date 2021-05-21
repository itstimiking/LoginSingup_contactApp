package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactapp.databinding.ActivityLoginBinding
import com.example.contactapp.databinding.ActivitySignupBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}