package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var etName: EditText? = null
    private var tvTheme0: TextView? = null
    private var tvTheme1: TextView? = null
    private var tvTheme2: TextView? = null
    private var tvTheme3: TextView? = null
    private var tvTheme4: TextView? = null
    private var tvTheme5: TextView? = null
    private var btnStart: Button? = null
    private var btnReset: Button? = null

    private var themeSet = mutableSetOf<Int>()

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        themeSet.clear()
        etName = findViewById(R.id.tv_name)
        btnStart = findViewById(R.id.btn_start)
        btnStart?.setOnClickListener(this)
        btnReset = findViewById(R.id.btnReset)
        btnReset?.setOnClickListener(this)

        tvTheme0 = findViewById(R.id.tvTheme0)
        tvTheme0?.setOnClickListener(this)
        tvTheme1 = findViewById(R.id.tvTheme1)
        tvTheme1?.setOnClickListener(this)
        tvTheme2 = findViewById(R.id.tvTheme2)
        tvTheme2?.setOnClickListener(this)
        tvTheme3 = findViewById(R.id.tvTheme3)
        tvTheme3?.setOnClickListener(this)
        tvTheme4 = findViewById(R.id.tvTheme4)
        tvTheme4?.setOnClickListener(this)
        tvTheme5 = findViewById(R.id.tvTheme5)
        tvTheme5?.setOnClickListener(this)

    }


   fun setDefaultBackTint(){
       var themes = listOf<TextView?>(tvTheme0,tvTheme1,tvTheme2,tvTheme3,tvTheme4,tvTheme5)
       for(textView in themes) {
           textView?.background =
               ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
       }
   }
   override fun onClick(p0:View?) {
         when(p0?.id){
             R.id.tvTheme0 -> {
                 tvTheme0?.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
                 themeSet.add(0)
             }
             R.id.tvTheme1 -> {
                 tvTheme1?.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
                 themeSet.add(1)
             }
             R.id.tvTheme2 -> {
                 tvTheme2?.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
                 themeSet.add(2)
             }
             R.id.tvTheme3 -> {
                 tvTheme3?.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
                 themeSet.add(3)
             }
             R.id.tvTheme4 -> {
                 tvTheme4?.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
                 themeSet.add(4)
             }
             R.id.tvTheme5 -> {
                 tvTheme5?.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
                 themeSet.add(5)
             }
             R.id.btn_start -> {
                 if (etName?.text!!.isEmpty()){
                     Toast.makeText(this, "Enter a Name", Toast.LENGTH_SHORT).show()
                 }else{
                     val intent: Intent = Intent(this, QuizQuestionsActivity::class.java)
                     intent.putExtra(Constants.USER_NAME, etName?.text.toString())
                     intent.putExtra(Constants.THEME_LIST, themeSet.toIntArray())
                     startActivity(intent)
                     finish()
                 }
             }
             R.id.btnReset -> {
                 setDefaultBackTint()
                 themeSet.clear()
             }
         }
    }


}
