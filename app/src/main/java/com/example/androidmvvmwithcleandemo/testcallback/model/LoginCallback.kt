package com.example.androidmvvmwithcleandemo.testcallback.model

interface LoginCallback {

    fun success(loginData: LoginData)
    fun error(error: String)
}