package com.example.androidmvvmwithcleandemo.testcallback.model

class LoginRepoImpl : LoginRepo {

    override fun getUserData(userName: String, password: String, serviceCallback: LoginCallback) {
        Thread(Runnable {
            Thread.sleep(2000)
            val loginData = LoginData(userName, "ankitbajajbajaj1989@gmail.com")
            serviceCallback.success(loginData)
        }).start()
    }

}