package com.example.androidmvvmwithcleandemo.testcallback.viewmodel

import com.example.androidmvvmwithcleandemo.testcallback.model.LoginDataRx

data class LoginViewStateRx(var loginData: LoginDataRx? = null, var error: String? = null) {
}