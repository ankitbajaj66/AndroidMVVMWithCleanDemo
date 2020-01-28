package com.example.androidmvvmwithcleandemo.testcallback.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidmvvmwithcleandemo.R
import com.example.androidmvvmwithcleandemo.testcallback.model.LoginRepoImpl
import com.example.androidmvvmwithcleandemo.testcallback.model.LoginRepoImplRX
import com.example.androidmvvmwithcleandemo.testcallback.viewmodel.LoginViewModel
import com.example.androidmvvmwithcleandemo.testcallback.viewmodel.LoginViewModelFactory
import com.example.androidmvvmwithcleandemo.testcallback.viewmodel.LoginViewModelRx
import com.example.androidmvvmwithcleandemo.testcallback.viewmodel.LoginViewModelFactoryRx
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val repo = LoginRepoImpl()
        loginViewModel =
            ViewModelProviders.of(this, LoginViewModelFactory(repo)).get(LoginViewModel::class.java)

        btn_login.setOnClickListener {
            loginViewModel.onLoginClicked(
                edt_userName.text.toString(),
                edt_password.text.toString()
            )
        }

        loginViewModel.loginViewState.observe(this, Observer {

            it.loginData?.let {
                Toast.makeText(this, it.email, Toast.LENGTH_LONG).show()
            }

            it.error?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }

        })
    }
}
