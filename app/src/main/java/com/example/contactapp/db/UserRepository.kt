package com.example.contactapp.db

import android.content.Context
import android.provider.Settings
import androidx.lifecycle.LiveData
import com.example.contactapp.db.UserDb.Companion.invoke
import com.example.contactapp.db.entity.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserRepository(context: Context) {

    private val db = UserDb.invoke(context)

    fun getAll (): List<UserData> = db.userDao().getAll()

    fun findUser(email: String, password: String): UserData?{
        var user: UserData? = null

        GlobalScope.launch {
            withContext(Dispatchers.IO){
                user = db.userDao().findUser(email,password)
            }
        }
    }

    fun insertUser(user: UserData){
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                db.userDao().insertUser(user)
            }
        }
    }
}