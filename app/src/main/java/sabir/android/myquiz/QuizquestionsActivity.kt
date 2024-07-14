package sabir.android.myquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizquestionsActivity : AppCompatActivity() , View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUserNmae:String?=null
    private var mCorrectAnswers:Int=0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var tvOptionone: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnSubmit: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizquestions)

        mUserNmae=intent.getStringExtra(Consytants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tvOptionone = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)

        tvOptionone?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Consytants.GetQuestions()


        setQuestion()
    }

    private fun setQuestion() {

        defaultOptionView()
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionone?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if (mCurrentPosition == mQuestionsList!!.size) {
            btnSubmit?.text = "FINISH"
        } else {
            btnSubmit?.text = "SUBMIT"
        }


    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        tvOptionone?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selectedoption_border_bg
        )
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option_one -> {
                tvOptionone?.let {
                    selectedOptionView(it, 1)
                }

            }
            R.id.tv_option_two -> {
                tvOptionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tv_option_three -> {
                tvOptionThree?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_option_four -> {
                tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent=Intent(this,ResultActivity::class.java)
                            intent.putExtra(Consytants.USER_NAME,mUserNmae)
                            intent.putExtra(Consytants.COORECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Consytants.TOTAL_QUESTIONS,mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++
                    }
                    answerView(
                        question.correctAnswer,
                        R.drawable.correct_option_border_bg
                    )
                    if (mCurrentPosition == mQuestionsList!!.size){
                        btnSubmit?.text ="FINISH"
                    }else{
                        btnSubmit?.text ="GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }

            }

        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tvOptionone?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )

            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}
