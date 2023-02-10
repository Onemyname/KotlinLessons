package ru.konovalov.morecats

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("ResourceType")
    fun onImageClick(view: View) {
        val img1 : ImageButton = findViewById(R.id.imageButton1)
        val img2 : ImageButton = findViewById(R.id.imageButton2)
        val img3 : ImageButton = findViewById(R.id.imageButton3)
        val img4 : ImageButton = findViewById(R.id.imageButton4)
        val img5 : ImageButton = findViewById(R.id.imageButton5)
        val text_window1: TextView = findViewById(R.id.textView1)
        val text_window2: TextView = findViewById(R.id.textView2)
        val text_window3: TextView = findViewById(R.id.textView3)
        view.visibility = View.INVISIBLE
        val phrases = listOf(
            "Иди убери мой лоток",
            "Покорми и убирайся вон",
            "Ты чего, не трожь меня",
            "Ах ты ж кожаный мешок",
            "Я сделаю тебе больно по-другому: \"егоные\"",
            "Ночью мы выцарапаем тебе глаза",
            "Мяу")

        val shuffledList = phrases.shuffled()

        text_window1.text = shuffledList[0]
        text_window2.text = shuffledList[1]
        text_window3.text = shuffledList[2]

        if(img1.isInvisible && img2.isInvisible && img3.isInvisible && img4.isInvisible && img5.isInvisible){
            text_window1.setText(R.string.End)
            text_window2.setText(R.string.End)
            text_window3.setText(R.string.End)
        }

    }
}