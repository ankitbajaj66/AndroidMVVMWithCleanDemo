package com.example.practice.dagger.daggerloginexample.di

import com.example.practice.dagger.daggerloginexample.LoginActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 *Created by Ankit Bajaj on 13-02-2020.
 *
 * We have all the Activity
 */

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesLoginActivity(): LoginActivity

}