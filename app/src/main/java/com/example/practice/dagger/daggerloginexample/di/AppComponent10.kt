package com.example.practice.dagger.daggerloginexample.di

import android.app.Application
import com.example.practice.dagger.daggerloginexample.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 *Created by Ankit Bajaj on 13-02-2020.
 */
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class, AppModule::class])
interface AppComponent10 : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent10
    }
}