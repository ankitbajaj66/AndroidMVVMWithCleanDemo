package com.example.androidmvvmwithcleandemo.testcallback.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidmvvmwithcleandemo.testcallback.model.*

class LoginViewModel(private val loginRepo: LoginRepo) : ViewModel() {

    private val _loginViewState = MutableLiveData<LoginViewState>()
    val loginViewState: LiveData<LoginViewState> = _loginViewState

    fun onLoginClicked(userName: String?, password: String?) {
        loginRepo.getUserData(userName!!, password!!, object : LoginCallback {
            override fun error(error: String) {
                _loginViewState.postValue(LoginViewState(loginData = null, error = error))
            }

            override fun success(loginData: LoginData) {
                _loginViewState.postValue(LoginViewState(loginData = loginData, error = null))
            }
        })
    }
}