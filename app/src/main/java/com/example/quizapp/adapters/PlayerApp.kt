package com.example.quizapp.adapters

import android.app.Application
import com.example.quizapp.data.AppDatabase
//refrence to db follows Singleton design pattern
class PlayerApp: Application() {
    val db by lazy {
        AppDatabase.getInstance(this)
    }
}