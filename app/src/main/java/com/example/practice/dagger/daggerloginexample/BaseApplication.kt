package com.example.practice.dagger.daggerloginexample

import com.example.practice.dagger.daggerloginexample.di.DaggerAppComponent10
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 *Created by Ankit Bajaj on 13-02-2020.
 */
class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent10.builder().application(this).build()
    }
}