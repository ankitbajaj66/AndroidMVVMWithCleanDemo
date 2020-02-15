package com.example.practice.dagger.daggersingleton

import dagger.Component

/**
 *Created by Ankit Bajaj on 11-02-2020.
 */
@PerApp8
@Component(modules = [DriverModule::class])
interface AppComponent {

    fun getDriver() : Driver7
}