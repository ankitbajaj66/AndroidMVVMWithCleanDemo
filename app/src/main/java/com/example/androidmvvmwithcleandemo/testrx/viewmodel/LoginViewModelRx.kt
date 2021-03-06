package com.example.androidmvvmwithcleandemo.testcallback.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidmvvmwithcleandemo.post.domain.common.TransformerRx
import com.example.androidmvvmwithcleandemo.post.presentation.posts.PostsViewState
import com.example.androidmvvmwithcleandemo.testcallback.model.*
import com.example.androidmvvmwithcleandemo.testrx.schuedular.BaseSchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginViewModelRx(
    private val loginRepo: LoginRepoRx, private val schedulerProvider: BaseSchedulerProvider
) : ViewModel() {

    private val _loginViewState = MutableLiveData<LoginViewStateRx>()
    val loginViewState: LiveData<LoginViewStateRx> = _loginViewState

    init {
        val viewState = LoginViewStateRx()
        this._loginViewState.value = viewState
    }

    fun onLoginClicked(userName: String?, password: String?) {

        loginRepo.getUserDataRx(userName!!, password!!).subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe {

                val newViewState = _loginViewState.value?.copy(
                    loginData = it, error = null
                )
                _loginViewState.value = newViewState

            }
    }
}