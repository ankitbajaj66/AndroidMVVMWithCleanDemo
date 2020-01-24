package com.example.androidmvvmwithcleandemo.post.common.utils


import android.text.TextUtils
import androidx.core.util.PatternsCompat


class Validator {
    companion object
    {
        fun isUserNameValid(username: String): Boolean =  !isEmpty(username) && PatternsCompat.EMAIL_ADDRESS.matcher(username).matches();
        fun isPasswordValid(password: String): Boolean = password.length > 3

        fun isEmpty(str: CharSequence?): Boolean {
            return str == null || str.length == 0
        }
    }
}