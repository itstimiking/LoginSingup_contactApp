package com.example.contactapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contactapp.db.dao.UserDao
import com.example.contactapp.db.entity.UserData

@Database(entities = arrayOf(UserData::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}