package com.example.practice.dagger.subcomponentwithbuilder


import com.example.practice.dagger.daggersingleton.PerApp8
import com.example.practice.dagger.daggersingleton.PerApp9
import dagger.Component
import dagger.Subcomponent

/**
 *Created by Ankit Bajaj on 11-02-2020.
 */
@PerApp9
@Component(modules = [DriverModule9::class])
interface PerAppComponent9 {
    fun getActivityComponentBuilder(): PerActivityComponent9.Builder
}