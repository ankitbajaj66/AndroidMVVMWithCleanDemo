package com.example.practice.dagger.daggerloginexample

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.RequestManager
import com.example.androidmvvmwithcleandemo.R
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_dagger_login.*
import javax.inject.Inject
import javax.inject.Named

class LoginActivity : DaggerAppCompatActivity() {

/*
inject primitive fields
    @JvmField // expose a field
    @Inject
    internal var isAppNull: Boolean = false*/

    @Inject
    lateinit var drawable: Drawable

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_login)

        setup()
    }

    private fun setup() {

        requestManager.load(drawable).into(login_logo)
    }
}
