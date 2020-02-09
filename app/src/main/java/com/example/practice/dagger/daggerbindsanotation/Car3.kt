package com.example.practice.dagger.daggerbindsanotation

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
class Car3 @Inject constructor(
    private val wheels3: Wheels3,
    private val dieselEngine3: DieselEngine3
) {

    fun ready() {
        wheels3.ready()
        dieselEngine3.ready()
    }
}