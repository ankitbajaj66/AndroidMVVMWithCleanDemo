package com.example.androidmvvmwithcleandemo.testcallback.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidmvvmwithcleandemo.R
import com.example.androidmvvmwithcleandemo.post.domain.entity.PostEntity
import com.example.androidmvvmwithcleandemo.post.presentation.common.AsyncTransformer
import com.example.androidmvvmwithcleandemo.testcallback.model.LoginDataRx
import com.example.androidmvvmwithcleandemo.testcallback.model.LoginRepoImplRX
import com.example.androidmvvmwithcleandemo.testcallback.viewmodel.LoginViewModelRx
import com.example.androidmvvmwithcleandemo.testcallback.viewmodel.LoginViewModelFactoryRx
import com.example.androidmvvmwithcleandemo.testrx.commons.AsyncTransformerRx
import com.example.androidmvvmwithcleandemo.testrx.schuedular.SchedulerProvider
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivityRx : AppCompatActivity() {

    lateinit var loginViewModel: LoginViewModelRx

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val repo = LoginRepoImplRX()
        // Transformer
        val asyncTransformer = AsyncTransformerRx<LoginDataRx>()

        val schedulerProvider = SchedulerProvider()

        loginViewModel =
            ViewModelProviders.of(this, LoginViewModelFactoryRx(repo, schedulerProvider))
                .get(LoginViewModelRx::class.java)

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
