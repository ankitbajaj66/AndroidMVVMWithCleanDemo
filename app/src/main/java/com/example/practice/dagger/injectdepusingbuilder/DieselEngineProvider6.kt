package com.example.practice.dagger.injectdepusingbuilder

import dagger.Module
import dagger.Provides

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
@Module
class DieselEngineProvider6 {

    @Provides
    fun provideDieselEngine(dieselEngine6: DieselEngine6): Engine6 {
        return dieselEngine6
    }
}