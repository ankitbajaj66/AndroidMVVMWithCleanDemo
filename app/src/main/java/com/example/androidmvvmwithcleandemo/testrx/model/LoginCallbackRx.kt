package com.example.androidmvvmwithcleandemo.testcallback.model

interface LoginCallbackRx {

    fun success(loginData: LoginDataRx)
    fun error(error: String)
}