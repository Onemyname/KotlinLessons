package ru.konovalov.sherlockholmes

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout

const val THIEF = "ru.konovavlov.sherlockholmes.THIEF"

class ChooseThief: Activity() {

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation", "ShowToast")
    override fun onCreate(savedInstanceState: Bundle?, ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_thief)

        val group: RadioGroup = findViewById(R.id.groupOfAnswers)
        val button_help : Button = findViewById(R.id.button_help)
        val toast = Toast.makeText(applicationContext,
            getString(R.string.caseToast),
            Toast.LENGTH_LONG)


        button_help.setOnClickListener{
            val toastContainer : LinearLayout = toast.view as LinearLayout
            val catImage = ImageView(this)
            catImage.setImageResource(R.drawable.sherlock)
            toastContainer.addView(catImage,0)
            toastContainer.setBackgroundColor(Color.TRANSPARENT)
            toast.show()
        }



        group.setOnCheckedChangeListener{_,optionId->
            val  answerIntent = Intent()
            when(optionId){
                R.id.radioButton_watson->{
                    answerIntent.putExtra(THIEF,"Ватсон")
                    setResult(0, answerIntent)
                    finish()
                }
                R.id.radioButton_cat->{
                    answerIntent.putExtra(THIEF, "Васька")
                    setResult(RESULT_OK, answerIntent)
                    finish()
                }
                R.id.radioButton_john->{
                    answerIntent.putExtra(THIEF,"Джон")
                    setResult(0, answerIntent)
                    finish()
                }

            }

        }
    }

}
