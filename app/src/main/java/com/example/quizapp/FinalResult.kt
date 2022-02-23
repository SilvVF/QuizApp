package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class FinalResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_result)
        val tvMsg: TextView = findViewById(R.id.tv_result_msg)
        val correctNum: Int = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val totalNum: Int = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val tvResult: TextView = findViewById(R.id.textViewResult)
        val tvName: TextView = findViewById(R.id.textNameFinal)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)
        tvResult.text = "Your Score is $correctNum out of $totalNum"

        if(correctNum == totalNum) {
            tvMsg.text = "Congratulations!\nPerfect Score"
        }else if(correctNum > totalNum / 2){
            tvMsg.text = "Good Try!\n Over 50%"
        }else if (correctNum < totalNum / 2){
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