package com.example.androidmvvmwithcleandemo.testcallback.commons

import android.util.Patterns
import androidx.core.util.PatternsCompat

class UtilsRx {

    companion object {
        // A placeholder username validation check
        fun isUserNameValid(username: String): Boolean {
            return if (username.contains('@')) {
                PatternsCompat.EMAIL_ADDRESS.matcher(username).matches()
            } else {
                username.isNotBlank()
            }
        }

        // A placeholder password validation check
        fun isPasswordValid(password: String): Boolean {
            return password.length > 5
        }
    }
}