package com.example.androidmvvmwithcleandemo.testcallback.model

interface LoginRepo {

    fun getUserData(userName: String, password: String, serviceCallback: LoginCallback)
}