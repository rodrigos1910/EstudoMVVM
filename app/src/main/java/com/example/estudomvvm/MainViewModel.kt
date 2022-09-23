package com.example.estudomvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    //MutableLiveData permite que a view Model recebe as informações da activity via notificação
    // meio que um Observer
    private var textWelcome = MutableLiveData<String>()
    private var login = MutableLiveData<Boolean>()
    private var personRepository = PersonRepository()

    init {
        textWelcome.value = "Olá Observador"
    }


    fun welcome() : LiveData<String>{
        return textWelcome
    }

    fun login() : LiveData<Boolean>{
        return login
    }


    fun doLogin(email: String, password: String) {
            // logica
        login.value = personRepository.login(email,password)
    }

}