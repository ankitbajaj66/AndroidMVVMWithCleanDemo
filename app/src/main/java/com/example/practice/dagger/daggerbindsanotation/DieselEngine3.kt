package com.example.practice.dagger.daggerbindsanotation

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */

class DieselEngine3 @Inject constructor(): Engine3 {
    override fun ready() {
        println("Diesel Engine Ready")
    }
}