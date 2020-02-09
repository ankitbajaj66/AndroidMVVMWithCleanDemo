package com.example.practice.dagger.daggersample

import dagger.Component

/**
 *Created by Ankit Bajaj on 08-02-2020.
 */
@Component
interface CarComponent {
    fun getCar(): Car

    fun inject(testInjectActivity: TestInjectActivity)
}