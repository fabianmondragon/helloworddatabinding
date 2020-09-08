package com.example.helloworlddatabinding

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var registerValidation = RegisterValidation()
    lateinit var password: CharSequence


    fun onUserNameChange(s: CharSequence, start: Int, before: Int, count: Int) {
        registerValidation.validateUserName(s.toString())
    }

    fun onPasswordChange(s: CharSequence, start: Int, before: Int, count: Int) {
        password = s
        registerValidation.validatePassword(s.toString())
    }

    fun onPasswordAgainChange(s: CharSequence, start: Int, before: Int, count: Int) {
        registerValidation.validatePasswordAgain(s.toString(), password.toString())
    }

    fun onEmailChange(s: CharSequence, start: Int, before: Int, count: Int) {
        registerValidation.email(s.toString())
    }

    fun register() {

        if (registerValidation.validateField()) {
            println("You can register")
        }

    }
}