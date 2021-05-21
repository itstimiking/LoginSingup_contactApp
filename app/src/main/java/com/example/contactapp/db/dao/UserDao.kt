package com.example.contactapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.contactapp.db.entity.UserData

@Dao
interface UserDao {
    @Query("SELECT * FROM user_data")
    fun getAll(): List<UserData>

    @Query("SELECT * FROM user_data WHERE email LIKE :email AND " +
            "password LIKE :password LIMIT 1")
    fun findUser(email: String, password: String): UserData

    @Insert
    fun insertUser(vararg users: UserData)
}