package com.example.contactapp.db

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.contactapp.db.entity.UserData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel: ViewModel() {

    var loggedInUser = MutableLiveData<UserData>()
    private lateinit var userRepo: UserRepository

    override fun onCleared() {
        super.onCleared()
    }

    fun logInUser(context: Context,email: String,password: String){
        userRepo = UserRepository(context)

        GlobalScope.launch {
            withContext(Dispatchers.IO){
                val user = userRepo.findUser(email,password)
                loggedInUser.postValue(user)
            }
        }
    }

    fun addUser(context:Context, newUser: UserData){
        userRepo = UserRepository(context)

        GlobalScope.launch {
            withContext(Dispatchers.IO){
                userRepo.insertUser(newUser)

            }
        }


    }
}