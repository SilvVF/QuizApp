package com.example.quizapp

import android.app.Application

class PlayerApp: Application() {
    val db by lazy {
        AppDatabase.getInstance(this)
    }
}