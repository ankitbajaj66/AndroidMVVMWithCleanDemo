package com.example.practice.dagger.daggersingleton

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 11-02-2020.
 */
@PerActiivty8
class Car7 @Inject constructor(private val driver: Driver7) {

    init {
        println("Car object craeted")
    }

    fun drive() {
        println(" $driver drives $this")
    }
}