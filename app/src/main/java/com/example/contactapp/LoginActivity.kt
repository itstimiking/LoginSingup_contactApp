package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.contactapp.databinding.ActivityLoginBinding
import com.example.contactapp.db.UserRepository
import com.example.contactapp.db.UserViewModel
import com.example.contactapp.db.entity.UserData

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel
    private lateinit var binding: ActivityLoginBinding
    private var user: UserData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.signinButton.setOnClickListener {
            loginUser()
        }

        viewModel.loggedInUser?.observe(this, Observer { newUser ->
            updateUser(user)
            Log.d("LOGINACTIVITY", "*************########### LIVE DATA OBSERVER CALLED ###########################************")
        })
    }

    private fun updateUser(newUser: UserData?) {
        user = newUser
        if(user != null){
            Log.d("LOGINACTIVITY", "*************########### user logged in ###########################************ $user")
        }else{
            Log.d("LOGINACTIVITY", "*************########### NO USER ###########################************")
        }
    }

    private fun loginUser(){
        val email = binding.email.text.toString()
        val password = binding.password.text.toString()

        viewModel.logInUser(this,email,password)
    }
}