package com.example.practice.dagger.injectdepusingmoduleconstructor

import dagger.Component

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
@Component(modules = [DieselEngineProvider5::class])
interface CarComponentDepUsingModuleCons {

    fun getCar5(): Car5
}