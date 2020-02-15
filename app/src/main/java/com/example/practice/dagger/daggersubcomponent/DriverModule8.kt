package com.example.practice.dagger.daggersubcomponent

import com.example.practice.dagger.daggersingleton.PerApp8
import dagger.Module
import dagger.Provides

/**
 *Created by Ankit Bajaj on 11-02-2020.
 */
@Module
class DriverModule8 {

    @PerApp8
    @Provides
    fun providesDriver(): Driver8 = Driver8()
}