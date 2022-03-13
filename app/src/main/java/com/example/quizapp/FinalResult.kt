package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class FinalResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_result)
        val tvMsg: TextView = findViewById(R.id.tv_result_msg)
        val correctNum: Int = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalNum: Int = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val tvResult: TextView = findViewById(R.id.textViewResult)
        val tvName: TextView = findViewById(R.id.textNameFinal)

        val name: String = intent.getStringExtra(Constants.USER_NAME) ?: ""
        val score: Int = ((correctNum.toDouble()/ totalNum.toDouble()) * 100 ).toInt()

        val playerDao = (application as PlayerApp).db.playerDao()
        lifecycleScope.launch {
            playerDao.insert(
                Player(
                    playerName = name,
                    score = score
                )
            )
        }

        tvName.text = name
        tvResult.text = "Your Score is $correctNum out of $totalNum"

        if (correctNum == totalNum) {
            tvMsg.text = "Congratulations!\nPerfect Score"
        } else if (correctNum > totalNum / 2) {
            tvMsg.text = "Good Try!\n Over 50%"
        } else if (correctNum < totalNum / 2) {
            tvMsg.text = "Better Luck Next Time :("
        }

        val btnFinish: Button = findViewById(R.id.btnFinish)
        btnFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}