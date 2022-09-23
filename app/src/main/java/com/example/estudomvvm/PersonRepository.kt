package com.example.estudomvvm

class PersonRepository {

    fun login(email: String, password: String) : Boolean{
        if (email != "" && password != ""){
            return false
        }


        return true
    }

}