package ru.konovalov.sherlockholmes

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RadioGroup
const val THIEF = "ru.konovavlov.sherlockholmes.THIEF"

class ChooseThief: Activity() {

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?, ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_thief)

        val group: RadioGroup = findViewById(R.id.groupOfAnswers)
        val image: ImageView = findViewById(R.id.kolbasa)
        image.visibility = View.VISIBLE

        group.setOnCheckedChangeListener{_,optionId->
            val  answerIntent = Intent()
            when(optionId){
                R.id.radioButton_watson->{
                    answerIntent.putExtra(THIEF,"Ватсон")
                    setResult(0, answerIntent)
                }
                R.id.radioButton_cat->{
                    answerIntent.putExtra(THIEF, "Васька")
                    setResult(RESULT_OK, answerIntent)
                }
                R.id.radioButton_john->{
                    answerIntent.putExtra(THIEF,"Джон")
                    setResult(0, answerIntent)
                }
            }
            finish()
        }
    }

}
