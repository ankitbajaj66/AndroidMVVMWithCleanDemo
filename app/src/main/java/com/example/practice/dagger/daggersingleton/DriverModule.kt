package com.example.practice.dagger.daggersingleton

import dagger.Module
import dagger.Provides

/**
 *Created by Ankit Bajaj on 11-02-2020.
 */
@Module
class DriverModule {

    @PerApp8
    @Provides
    fun provideDriver() = Driver7()

}