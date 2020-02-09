package com.example.practice.daggersample

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 08-02-2020.
 */
class Car @Inject constructor(private val wheels: Wheels) {

    @Inject
    lateinit var engine: Engine

    init {
        println("Car constructor")
    }

    @Inject
    fun setDriver(driver: Driver)
    {

    }
}