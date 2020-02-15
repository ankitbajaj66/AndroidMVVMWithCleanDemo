package com.example.practice.dagger.daggersubcomponent

import com.example.practice.dagger.daggersingleton.PerActiivty8
import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 11-02-2020.
 */
@PerActiivty8
class Car8 @Inject constructor(private val driver8: Driver8) {

    init {
        println("Car8 object craeted")
    }

    fun drive() {
        println(" $driver8 drives $this")
    }
}