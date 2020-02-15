package com.example.practice.dagger.daggersingleton

import dagger.Component

/**
 *Created by Ankit Bajaj on 11-02-2020.
 */
@PerActiivty8
@Component(dependencies = [AppComponent::class])
interface ActivityComponent {
    fun getCar(): Car7
}