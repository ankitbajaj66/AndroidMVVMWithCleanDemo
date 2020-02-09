package com.example.practice.dagger.daggersample

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
class Wheels @Inject constructor() {
    init {
        println("Wheels constructor")
    }
}