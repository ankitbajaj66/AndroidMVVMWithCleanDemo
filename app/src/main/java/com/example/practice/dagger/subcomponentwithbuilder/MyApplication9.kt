package com.example.practice.dagger.subcomponentwithbuilder

import android.app.Application

/**
 *Created by Ankit Bajaj on 11-02-2020.
 */
class MyApplication9 : Application() {

    lateinit var perAppComponent9: PerAppComponent9

    override fun onCreate() {
        super.onCreate()

        perAppComponent9 = DaggerPerAppComponent9.create()
    }
}