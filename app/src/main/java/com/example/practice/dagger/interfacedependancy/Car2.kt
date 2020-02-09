package com.example.practice.dagger.interfacedependancy

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
class Car2 @Inject constructor(private val engine2: Engine2, private val wheel2: Wheel2) {

    fun ready() {
        engine2.engineReady()
        wheel2.wheelReady()
    }
}