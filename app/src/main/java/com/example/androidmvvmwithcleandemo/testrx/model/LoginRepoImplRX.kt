package com.example.androidmvvmwithcleandemo.testcallback.model

import android.service.autofill.UserData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class LoginRepoImplRX : LoginRepoRx {

    override fun getUserData(userName: String, password: String, serviceCallback: LoginCallbackRx) {
        Thread(Runnable {
            Thread.sleep(2000)
            val loginData = LoginDataRx(userName, "ankitbajajbajaj1989@gmail.com")
            serviceCallback.error("Server Error")
        }).start()
    }

    override fun getUserDataRx(userName: String, password: String): Observable<LoginDataRx> {
        return Observable.just(getUserData()).delay(3, TimeUnit.SECONDS)
    }

    private fun getUserData(): LoginDataRx {
        return LoginDataRx("Ankit", "ankitbajajbajaj@gmail.com")
    }
}