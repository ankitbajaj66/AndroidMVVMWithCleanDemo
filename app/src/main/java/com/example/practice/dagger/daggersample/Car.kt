package com.example.practice.dagger.daggersample

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 08-02-2020.
 */
class Car @Inject constructor(private val wheels: Wheels) {

    lateinit var driver1: Driver

    @Inject
    lateinit var engine: Engine

    init {
        println("Car constructor")
    }

    @Inject
    fun setDriver(driver: Driver) {
        println("set driver method constructor")
        driver1 = driver
    }
}