package com.example.androidmvvmwithcleandemo.post.common.utils

import androidx.core.util.PatternsCompat


class Validator {
    companion object
    {
        fun isUserNameValid(username: String): Boolean =  PatternsCompat.EMAIL_ADDRESS.matcher(username).matches();
        fun isPasswordValid(password: String): Boolean = password.length > 3
    }
}