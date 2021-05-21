package com.example.contactapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactapp.db.dao.UserDao
import com.example.contactapp.db.entity.UserData

@Database(entities = arrayOf(UserData::class), version = 1)
abstract class UserDb : RoomDatabase(){
    abstract fun userDao(): UserDao

    companion object{
        @Volatile private var instance: UserDb? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context, UserDb::class.java, "user_data").build()
    }
}