package com.konovalov.mediatorlivedata

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    val dataFirst = MutableLiveData<Int>()
    val dataSecond = MutableLiveData<Int>()
    val mediatorData = MediatorLiveData<Int>()
    private lateinit var saveButtonFirst: Button
    private lateinit var saveButtonSecond: Button
    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private lateinit var observer: Observer<Int>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveButtonFirst = findViewById(R.id.button_save_toFirst)
        saveButtonSecond = findViewById(R.id.button_save_toSecond)
        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editT)
        observer = Observer {  textView.text= it.toString() }
        mediatorData.addSource(dataFirst,observer)
        mediatorData.addSource(dataSecond,observer)


        saveButtonFirst.setOnClickListener{

            dataFirst.value = editText.text.toString().toInt()
        }

        saveButtonSecond.setOnClickListener{
            dataSecond.value = editText.text.toString().toInt()
        }


    }

    override fun onStart() {
        super.onStart()
        mediatorData.observe(this, observer)
    }

    override fun onStop() {
        super.onStop()
        mediatorData.removeObserver(observer)
    }
}