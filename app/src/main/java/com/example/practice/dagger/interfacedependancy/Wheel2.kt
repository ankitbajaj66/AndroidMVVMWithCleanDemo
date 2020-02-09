package com.example.practice.dagger.interfacedependancy

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
class Wheel2 @Inject constructor() {
    fun wheelReady() {
        println("Wheel ready")
    }
}