package com.konovalov.lifecycle


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer


class MainActivity : AppCompatActivity() {

    private val myData: MyData = MyData()
    private lateinit var observer: Observer<List<Employee>>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val butt: Button = findViewById(R.id.buttonSave)
        val editText: EditText = findViewById(R.id.editText)
        val textView: TextView = findViewById(R.id.textView)
        val remove : Button = findViewById(R.id.remove_button)

        observer = Observer {textView.text = it.toString() }

        butt.setOnClickListener{
            if(editText.text.isEmpty()){
                return@setOnClickListener
            }
            val array = editText.text.split(" ")
            if(array.size!=2){
                return@setOnClickListener
            }
            else{
                myData.addEmployeeToList(Employee(array[0],array[1]))
                myData.updateValueInData()
            }
        }

        remove.setOnClickListener{
            if(editText.text.isEmpty()){
                return@setOnClickListener
            }
            val array = editText.text.split(" ")
            if(array.size!=2){
                return@setOnClickListener
            }
            else {
                val removeEmployee = Employee(array[0],array[1])
                myData.value?.contains(removeEmployee)
                myData.removeEmployeeInList(removeEmployee)
                myData.updateValueInData()
            }
            }
        }

    override fun onStart() {
        super.onStart()
        myData.observe(this,observer)
    }

    override fun onStop() {
        super.onStop()
        myData.removeObserver(observer)
    }
}

