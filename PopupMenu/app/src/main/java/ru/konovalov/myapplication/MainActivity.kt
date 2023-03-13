package ru.konovalov.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var textView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(Settings.ACTION_DISPLAY_SETTINGS)
        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }

        button=findViewById(R.id.button)
        textView=findViewById(R.id.textview)

        val popupMenu = androidx.appcompat.widget.PopupMenu(this,textView)
        popupMenu.inflate(R.menu.popupmenu)
        popupMenu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menu1->{
                    textView.text ="PopuMenu1 was chosen"
                true
                }
                R.id.menu2->{
                    textView.text ="PopuMenu2 was chosen"
                    true}
                R.id.menu3 ->{
                    textView.text ="PopuMenu3 was chosen"
                    true}
                else-> {
                    textView.text = "Lev"
                    true
                }
            }
        }

        button.setOnClickListener{
            popupMenu.show()
        }

    }
}