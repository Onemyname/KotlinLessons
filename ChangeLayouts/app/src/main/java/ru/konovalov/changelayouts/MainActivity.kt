package ru.konovalov.changelayouts

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.info_button)
        val catDogButton: Button = findViewById(R.id.cat_dog_button)
        button.setOnClickListener{
            val intent = Intent(this@MainActivity, AboutActivity:: class.java)
            startActivity(intent)
        }
        catDogButton.setOnClickListener{
            val intent = Intent(this@MainActivity, SecondActivity:: class.java)
            startActivity(intent)
        }

    }
}