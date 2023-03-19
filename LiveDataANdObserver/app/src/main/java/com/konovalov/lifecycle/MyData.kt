package com.konovalov.lifecycle

import androidx.lifecycle.LiveData

class MyData : LiveData<List<Employee>>() {
    private companion object{
        val list = mutableListOf<Employee>()
    }

    fun addEmployeeToList(employee: Employee){
        list.add(employee)
    }

    fun removeEmployeeInList(employee: Employee){
        list.remove(employee)
    }

    fun updateValueInData(){
        value = list
    }
}