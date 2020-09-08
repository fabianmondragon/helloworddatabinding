package com.example.helloworlddatabinding

import androidx.databinding.ObservableField

class RegisterValidation {

    var isEnabled = ObservableField<Boolean>()
    var userNameError = ObservableField<String>()
    var passwordError = ObservableField<String>()
    var passwordErrorAgain = ObservableField<String>()
    var emailError = ObservableField<String>()

    var userName = ObservableField<String>()
    var password = ObservableField<String>()
    val passwordAgain = ObservableField<String>()
    val email = ObservableField<String>()

    var canRegister: Boolean = false
    private val passwordPattern =
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
    private val emailPattern = ("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
            + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
            + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
            + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$")


    fun validateUserName(userName: String) {
        if (userName.isEmpty()) {
            userNameError.set(ConstantPresentation.EMPTY_FIELD)
            canRegister = false
        } else {
            userNameError.set(null)
            canRegister = true
        }
    }

    fun validatePassword(s: CharSequence) {
        val regex = Regex(passwordPattern)
        s?.let {
            if (!regex.matches(it)) {
                passwordError.set(ConstantPresentation.PASSWORD_ERROR)
                canRegister = false
            } else {
                passwordError.set(null)
                canRegister = true
            }
        }
    }

    fun validatePasswordAgain(password: String, passwordAgain: String) {
        if (password != passwordAgain) {
            passwordErrorAgain.set(ConstantPresentation.PASSWORD_AGAIN_ERROR)
            canRegister = false
        } else {
            passwordErrorAgain.set(null)
            canRegister = true
        }
    }

    fun email(s: CharSequence) {
        val regex = Regex(emailPattern)
        s?.let {
            if (!regex.matches(it)) {
                emailError.set(ConstantPresentation.MAIL_ERROR)
                canRegister = false
            } else {
                emailError.set(null)
                canRegister = true
            }
        }
    }


    fun validateField() = canRegister
}