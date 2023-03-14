package ru.konovalov.sunrise

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sunImageView: ImageView = findViewById(R.id.sun)
        val sunriseAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.sun_rise)
        sunImageView.startAnimation(sunriseAnimation)

        val clockImage : ImageView = findViewById(R.id.clock)
        val clockAnimation : Animation = AnimationUtils.loadAnimation(this,R.anim.clock_turn)
        clockImage.startAnimation(clockAnimation)
    }
}