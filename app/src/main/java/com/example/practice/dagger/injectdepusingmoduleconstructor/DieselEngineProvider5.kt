package com.example.practice.dagger.injectdepusingmoduleconstructor

import dagger.Module
import dagger.Provides

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
@Module
class DieselEngineProvider5(private val horsePower: Int) {

    @Provides
    fun getDieselEngine(dieselEngine5: DieselEngine5): Engine5 {
        return dieselEngine5
    }

    @Provides
    fun providesHorsePower(): Int {
        return horsePower
    }
}