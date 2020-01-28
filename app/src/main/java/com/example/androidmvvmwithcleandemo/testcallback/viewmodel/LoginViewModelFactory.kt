package com.example.androidmvvmwithcleandemo.testcallback.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidmvvmwithcleandemo.testcallback.model.LoginRepo
import com.example.androidmvvmwithcleandemo.testcallback.model.LoginRepoRx

class LoginViewModelFactory(private val repo: LoginRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(repo) as T
    }
}