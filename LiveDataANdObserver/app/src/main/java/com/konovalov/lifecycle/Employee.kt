package com.konovalov.lifecycle

class Employee
    (val name: String,
val lastName: String){

    override fun toString(): String {
        return "Employee(name='$name', lastName='$lastName')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Employee

        if (name != other.name) return false
        if (lastName != other.lastName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + lastName.hashCode()
        return result
    }
}


