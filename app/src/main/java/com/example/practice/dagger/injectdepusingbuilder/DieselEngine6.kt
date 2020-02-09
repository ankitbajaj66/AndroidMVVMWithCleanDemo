package com.example.practice.dagger.injectdepusingbuilder

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
class DieselEngine6 @Inject constructor(private val horsePower: Int) : Engine6 {
    override fun ready() {
        println("Wheels6 Ready $horsePower")
    }
}