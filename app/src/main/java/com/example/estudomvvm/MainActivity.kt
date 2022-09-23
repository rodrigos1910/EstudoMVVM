package com.example.estudomvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.estudomvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //instancia a view model na mains, isso define que a viewmode acompanhe o ciclo de vida da activity
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonLogin.setOnClickListener(this)


        setObserver()


       // binding.textWelcome.text = "Olá"

    }

    override fun onClick(view: View) {
        when (view.id){
            R.id.button_login -> {
                val email = binding.editEmail.text.toString()
                val password = binding.editPassword.text.toString()

                viewModel.doLogin(email, password)

            }
        }
    }


    private fun setObserver(){
        //observador que trará os valores alterados na view model
        viewModel.welcome().observe(this, Observer {  binding.textWelcome.text = it })
        viewModel.login().observe(this, Observer {
            if (it){
                Toast.makeText(applicationContext, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Falha ao realizar o Login!", Toast.LENGTH_SHORT).show()
            }


        })
    }


}