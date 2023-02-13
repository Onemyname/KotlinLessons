package ru.konovalov.sherlockholmes

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CHOOSE_THIEF = 0
    }
    private lateinit var imageView: ImageView
    private lateinit var open_case : Button
    private lateinit var textInfo:  TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        open_case  = findViewById(R.id.button_open_case)
        imageView = findViewById(R.id.imageView_sherlock)
        textInfo  = findViewById(R.id.textView_info)

        open_case.setOnClickListener{
            val questionIntent = Intent(this@MainActivity,
            ChooseThief::class.java)
            startActivityForResult(questionIntent, REQUEST_CHOOSE_THIEF)
        }
    }

    @SuppressLint("SetTextI18n", "ResourceType")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CHOOSE_THIEF){
            val name = data?.getStringExtra(THIEF)
            if(resultCode==Activity.RESULT_OK){

                textInfo.text = "Ты раскрыл дело, Шерлок! $name оказался вором!"
            }
            else if(resultCode== 0){

                textInfo.text = "К сожалению $name не оказался вором"
            }
            else{
                textInfo.text = "Дело не решено, попробуй еще раз"
            }
        }
    }


}