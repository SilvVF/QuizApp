package com.example.quizapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Player::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun playerDao(): PlayerDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "AppDatabase"
                    ).enableMultiInstanceInvalidation()
                        .fallbackToDestructiveMigration()
                        .build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }

}