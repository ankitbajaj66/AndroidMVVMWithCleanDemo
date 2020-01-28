package com.example.androidmvvmwithcleandemo.testcallback.model

import io.reactivex.Observable

interface LoginRepoRx {

    fun getUserData(userName: String, password: String, serviceCallback: LoginCallbackRx)

    fun getUserDataRx(userName: String, password: String): Observable<LoginDataRx>
}