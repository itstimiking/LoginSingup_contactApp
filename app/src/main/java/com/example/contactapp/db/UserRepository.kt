package com.example.contactapp.db

import android.content.Context
import android.util.Log
import com.example.contactapp.db.entity.UserData

class UserRepository(context: Context) {

    private val db = UserDb.invoke(context)

    fun getAll (): List<UserData> = db.userDao().getAll()

    fun findUser(email: String, password: String): UserData{
        var user = db.userDao().findUser(email,password)
        return user
    }

    fun insertUser(user: UserData) {
        db.userDao().insertUser(user)
    }
}