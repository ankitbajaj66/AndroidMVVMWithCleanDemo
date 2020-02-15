package com.example.practice.dagger.daggersubcomponent


import com.example.practice.dagger.daggersingleton.PerApp8
import dagger.Component
import dagger.Subcomponent

/**
 *Created by Ankit Bajaj on 11-02-2020.
 */
@PerApp8
@Component(modules = [DriverModule8::class])
interface PerAppComponent8 {
    fun getActivityComponent(): PerActivityComponent8
}