package com.example.practice.dagger.subcomponentwithbuilder

import com.example.practice.dagger.daggersingleton.PerApp8
import com.example.practice.dagger.daggersingleton.PerApp9
import dagger.Module
import dagger.Provides

/**
 *Created by Ankit Bajaj on 11-02-2020.
 */
@Module
class DriverModule9 {

    @PerApp9
    @Provides
    fun providesDriver(): Driver9 = Driver9()
}