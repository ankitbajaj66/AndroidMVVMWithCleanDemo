package com.example.practice.dagger.daggersingleton

import android.app.Application

/**
 *Created by Ankit Bajaj on 11-02-2020.
 */
class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }
}