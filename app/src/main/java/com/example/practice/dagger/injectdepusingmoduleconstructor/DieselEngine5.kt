package com.example.practice.dagger.injectdepusingmoduleconstructor

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
class DieselEngine5 @Inject constructor(private val horsePower: Int) : Engine5 {

    override fun ready() {
        println("Engine5 Ready with $horsePower")
    }
}