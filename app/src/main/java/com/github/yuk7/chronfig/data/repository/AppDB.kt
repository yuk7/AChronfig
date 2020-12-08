package com.github.yuk7.chronfig.data.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.yuk7.chronfig.data.repository.config.Config
import com.github.yuk7.chronfig.data.repository.config.ConfigDao

@Database(entities = [Config::class], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun configDao(): ConfigDao

    companion object {
        private var instance: AppDB? = null

        fun getInstance(context: Context): AppDB {
            if (instance == null) {
                synchronized(AppDB::class) {
                    instance = Room.databaseBuilder(context.applicationContext, AppDB::class.java, "data")
                            .build()
                }
            }
            return instance!!
        }

        fun destroyInstance() {
            instance = null
        }
    }
}