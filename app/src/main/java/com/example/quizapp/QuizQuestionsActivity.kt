package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mQuestionList: ArrayList<Question>?  = null
    private var mCurrentPosition: Int = 1
    private var mSelectedOptionPosition: Int = 0
    private var mUserName:String? = null
    private var mCorrectAnswers: Int = 0
    private var themeList: IntArray? = null

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var characterImage: ImageView? = null

    private var tvOp1: TextView? = null
    private var tvOp2: TextView? = null
    private var tvOp3: TextView? = null
    private var tvOp4: TextView? = null
    private var btnSubmit: Button? = null
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        themeList = intent.getIntArrayExtra(Constants.THEME_LIST)
        mQuestionList = Constants.getQuestions(themeList!!.toList())


        characterImage = findViewById(R.id.imageViewCharacter)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.textViewProgress)
        tvQuestion = findViewById(R.id.textQuestion)

        tvOp1 = findViewById(R.id.textViewOptionOne)
        tvOp1?.setOnClickListener(this)

        tvOp2 = findViewById(R.id.textViewOptionTwo)
        tvOp2?.setOnClickListener(this)

        tvOp3 = findViewById(R.id.textViewOptionThree)
        tvOp3?.setOnClickListener(this)

        tvOp4 = findViewById(R.id.textViewOptionFour)
        tvOp4?.setOnClickListener(this)

        btnSubmit = findViewById(R.id.btn_submit)
        btnSubmit?.setOnClickListener(this)

        progressBar?.max = mQuestionList!!.size
        setQuestion()

    }



    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()

        tvOp1?.let {
                options.add(0, it)
            }
        tvOp2?.let {
            options.add(1, it)
        }
        tvOp3?.let {
            options.add(2, it)
        }
        tvOp4?.let {
            options.add(3, it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT

            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg,
            )

        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg,
        )
    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]

        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${mQuestionList?.size}"
        tvQuestion?.text = question.question

        characterImage?.setImageResource(question.image)
        tvOp1?.text = question.optionOne
        tvOp2?.text = question.optionTwo
        tvOp3?.text = question.optionThree
        tvOp4?.text = question.optionFour

        if(mCurrentPosition == mQuestionList?.size){
            btnSubmit?.text = "Submit"
        }else{
            btnSubmit?.text = "Submit"
        }
    }

    override fun onClick(view:View?) {
        when(view?.id){
            R.id.textViewOptionOne -> {
                Log.i("tv_was_clicked", "onClick: ")
                tvOp1?.let{
                    selectedOptionView(it,1)
                }
            }

            R.id.textViewOptionTwo -> {
                tvOp2?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.textViewOptionThree -> {
                tvOp3?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.textViewOptionFour -> {
                tvOp4?.let{
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit -> {
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> { setQuestion() }
                        else -> {
                            val intent = Intent(this,FinalResult::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if(question!!.correctAns != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAns, R.drawable.correct_option_border_bg)
                    if(mCurrentPosition == mQuestionList!!.size){
                        btnSubmit?.text = "Finish"
                    }else{
                        btnSubmit?.text = "Next"
                    }
                    mSelectedOptionPosition = 0
                }
            }

        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                tvOp1?.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                tvOp2?.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                tvOp3?.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                tvOp4?.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }


}