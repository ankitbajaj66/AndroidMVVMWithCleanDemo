package com.example.androidmvvmwithcleandemo.testrx.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.androidmvvmwithcleandemo.post.presentation.posts.PostsViewState
import com.example.androidmvvmwithcleandemo.testcallback.model.LoginDataRx
import com.example.androidmvvmwithcleandemo.testcallback.model.LoginRepoRx
import com.example.androidmvvmwithcleandemo.testcallback.viewmodel.LoginViewModelRx
import com.example.androidmvvmwithcleandemo.testcallback.viewmodel.LoginViewStateRx
import com.example.androidmvvmwithcleandemo.testrx.schuedular.TrampolineSchedulerProvider
import io.reactivex.Observable
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginViewModelRxTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var loginRepoRx: LoginRepoRx

    private lateinit var loginViewModelRx: LoginViewModelRx

    @Mock
    lateinit var observer: Observer<LoginViewStateRx>

    @Before
    fun setUp() {
        var schedulerProvider = TrampolineSchedulerProvider()
        MockitoAnnotations.initMocks(this)
        loginViewModelRx = LoginViewModelRx(loginRepoRx, schedulerProvider)
        loginViewModelRx.loginViewState.observeForever { observer }
    }

   /* @Test
    fun testInitialViewStateShowsLoading() {
        Mockito.verify(observer)
            .onChanged(LoginViewStateRx(loginData = null, error = null))
        Mockito.verifyZeroInteractions(observer)
    }*/

    @Test
    fun onLoginClicked() {

        var username = "Ankit"
        var password = "1234455"

        var loginDataRx = LoginDataRx(userName = "Ankit", email = "ankitbajaj1989@gmail.com")
        Mockito.`when`(loginRepoRx.getUserDataRx(username, password))
            .thenReturn(Observable.just(loginDataRx))
        loginViewModelRx.onLoginClicked(username, password)

        Mockito.verify(observer).onChanged(LoginViewStateRx(loginData = loginDataRx, error = null))
    }

    @After
    fun tearDown() {
    }
}