package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var etName: EditText? = null
    private var tvTheme0: CheckBox? = null
    private var theme0Check = false

    private var tvTheme1: CheckBox? = null
    private var theme1Check  = false

    private var tvTheme2: CheckBox? = null
    private var theme2Check  = false

    private var tvTheme3: CheckBox? = null
    private var theme3Check  = false
    private var btnStart: Button? = null


    private var themeSet = mutableSetOf<Int>()

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        themeSet.clear()
        etName = findViewById(R.id.tv_name)
        btnStart = findViewById(R.id.btn_start)
        btnStart?.setOnClickListener(this)

        tvTheme0 = findViewById(R.id.tvTheme0)
        tvTheme0?.setOnClickListener(this)

        tvTheme1 = findViewById(R.id.tvTheme1)
        tvTheme1?.setOnClickListener(this)

        tvTheme2 = findViewById(R.id.tvTheme2)
        tvTheme2?.setOnClickListener(this)

        tvTheme3 = findViewById(R.id.tvTheme3)
        tvTheme3?.setOnClickListener(this)


    }

   override fun onClick(p0:View?) {
       when(p0?.id) {
           R.id.tvTheme0,R.id.tvTheme1,R.id.tvTheme2,R.id.tvTheme3 -> setBgCheckBox()
           R.id.btn_start -> {
               if (etName?.text!!.isEmpty()) {
                   Toast.makeText(this, "Enter a Name", Toast.LENGTH_SHORT).show()
               } else {
                   if (tvTheme0!!.isChecked) themeSet.add(0)
                   if (tvTheme1!!.isChecked) themeSet.add(1)
                   if (tvTheme2!!.isChecked) themeSet.add(2)
                   if (tvTheme3!!.isChecked) themeSet.add(3)
                   if (themeSet.isEmpty()) {
                       themeSet.add(Random.nextInt(0, 2))
                       themeSet.add(Random.nextInt(0, 2))
                   }
                   val intent = Intent(this, QuizQuestionsActivity::class.java)
                   intent.putExtra(Constants.USER_NAME, etName?.text.toString())
                   intent.putExtra(Constants.THEME_LIST, themeSet.toIntArray())
                   startActivity(intent)
                   finish()
               }
           }
       }
   }

   private fun setBgCheckBox(){
       val selected = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
       val default = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
       if (tvTheme0!!.isChecked){
           tvTheme0?.background = selected
       }else{
           tvTheme0?.background = default
       }
       if (tvTheme1!!.isChecked){
           tvTheme1?.background = selected
       }else{
           tvTheme1?.background = default
       }
       if (tvTheme2!!.isChecked){
           tvTheme2?.background = selected
       }else{
           tvTheme2?.background = default
       }
       if (tvTheme3!!.isChecked){
           tvTheme3?.background = selected
       }else{
           tvTheme3?.background = default
       }
   }
}


