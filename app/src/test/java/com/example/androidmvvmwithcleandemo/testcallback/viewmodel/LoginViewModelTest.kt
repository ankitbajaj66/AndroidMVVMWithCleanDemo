package com.example.androidmvvmwithcleandemo.testcallback.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.androidmvvmwithcleandemo.testcallback.model.*
import com.nhaarman.mockitokotlin2.KArgumentCaptor
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.ArgumentMatchers.eq
import org.mockito.junit.MockitoJUnitRunner
import org.mockito4kotlin.annotation.KCaptor

@RunWith(MockitoJUnitRunner::class)
class LoginViewModelTest {

    @Captor
    lateinit var captor: ArgumentCaptor<LoginCallback>

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var loginRepo: LoginRepo

    private lateinit var loginViewModel: LoginViewModel

    @Captor
    lateinit var loginCallbackCaptor: ArgumentCaptor<LoginCallback>

    @KCaptor
    lateinit var kloginCallbackCaptor: KArgumentCaptor<LoginCallback>

    @Mock
    private lateinit var observer: Observer<LoginViewState>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        kloginCallbackCaptor = KArgumentCaptor(loginCallbackCaptor, LoginCallback::class)
        loginViewModel = LoginViewModel(loginRepo)
        loginViewModel.loginViewState.observeForever(observer)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getLoginViewState() {

    }

    @Test
    fun onLoginClicked() {
        var userName: String? = "Ankit"
        var password: String? = "12345"

        var loginData = LoginData(userName, email = "ahhjd@fh.com")
        loginViewModel.onLoginClicked(userName, password)

        Mockito.verify(loginRepo)
            .getUserData(eq(userName!!), eq(password!!), kloginCallbackCaptor.capture())
        kloginCallbackCaptor.firstValue.success(loginData)

        Mockito.verify(observer).onChanged(
            LoginViewState(loginData = loginData, error = null)
        )

    }
}