package com.example.practice.dagger.daggerbindsanotation

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
class Wheels3 @Inject constructor() {
    fun ready() {
        println("Wheels3 Ready")
    }
}