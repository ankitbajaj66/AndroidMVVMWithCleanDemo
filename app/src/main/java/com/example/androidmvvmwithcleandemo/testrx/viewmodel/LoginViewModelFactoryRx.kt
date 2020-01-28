package com.example.androidmvvmwithcleandemo.testcallback.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidmvvmwithcleandemo.post.domain.common.TransformerRx
import com.example.androidmvvmwithcleandemo.testcallback.model.LoginRepoRx
import com.example.androidmvvmwithcleandemo.testrx.schuedular.BaseSchedulerProvider

class LoginViewModelFactoryRx(private val repo: LoginRepoRx, private val schedulerProvider: BaseSchedulerProvider) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModelRx(repo, schedulerProvider) as T
    }
}