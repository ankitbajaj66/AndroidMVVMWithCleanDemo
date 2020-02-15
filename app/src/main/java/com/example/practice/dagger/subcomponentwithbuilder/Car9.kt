package com.example.practice.dagger.subcomponentwithbuilder

import com.example.practice.dagger.daggersingleton.PerActiivty8
import com.example.practice.dagger.daggersingleton.PerActiivty9
import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 11-02-2020.
 */
@PerActiivty9
class Car9 @Inject constructor(private val engine9: Engine9, private val driver9: Driver9) {

    init {
        println("Car9 object craeted")
    }

    fun drive() {
        engine9.ready()
        println(" $driver9 drives $this")
    }
}