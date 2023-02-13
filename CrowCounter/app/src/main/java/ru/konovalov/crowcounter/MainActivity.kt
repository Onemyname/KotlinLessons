package ru.konovalov.crowcounter

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.content.PackageManagerCompat.LOG_TAG

class MainActivity : AppCompatActivity() {
    private var crowCounter: Int =0
    private var cowCounter: Int = 0
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView : TextView = findViewById(R.id.textView)
        val button : Button = findViewById(R.id.button)
        val buttonCrowCounter : Button = findViewById(R.id.crows_counter)
        val buttonCowCounter : Button = findViewById(R.id.cow_counter)

//        button.setOnClickListener{
//            textView.text = "Добрый день!"
//        }

//        button.setOnClickListener { v ->
//            textView.text = "Hello Kitty!"
//            v.setBackgroundColor(Color.GREEN)
//        }

        button.setOnClickListener {
            textView.text = "Hello Kitty!"
            it.setBackgroundColor(Color.GREEN)
        }

        buttonCrowCounter.setOnClickListener {
            crowCounter++
            textView.text = "Я насчитал $crowCounter ворон"
            it.setBackgroundColor(Color.BLUE)

        }

        buttonCowCounter.setOnClickListener  {
            textView.text = "Я насчитал ${++cowCounter} коров"
            it.setBackgroundColor(Color.CYAN)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("crowCount", crowCounter)
        outState.putInt("cowCOunter", cowCounter)
    }

    protected override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        crowCounter = savedInstanceState.getInt("crowCount")
        cowCounter = savedInstanceState.getInt("cowCOunter")
    }
}