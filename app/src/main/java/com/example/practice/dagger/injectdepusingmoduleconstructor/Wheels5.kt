package com.example.practice.dagger.injectdepusingmoduleconstructor

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
class Wheels5 @Inject constructor() {
    fun ready() {
        println("Wheels5 Ready")
    }
}