package com.example.practice.dagger.daggersubcomponent

import android.app.Application

/**
 *Created by Ankit Bajaj on 11-02-2020.
 */
class MyApplication8 : Application() {

    lateinit var perAppComponent8: PerAppComponent8

    override fun onCreate() {
        super.onCreate()

        perAppComponent8 = DaggerPerAppComponent8.create()
    }
}