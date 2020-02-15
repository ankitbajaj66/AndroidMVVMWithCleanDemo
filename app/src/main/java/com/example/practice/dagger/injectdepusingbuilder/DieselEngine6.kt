package com.example.practice.dagger.injectdepusingbuilder

import javax.inject.Inject
import javax.inject.Named

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
class DieselEngine6 @Inject constructor(
    @Named("horserPower")
    private val horsePower: Int,
    @Named("engineCapacity") private val engineCapacity: Int
) :
    Engine6 {
    override fun ready() {
        println("Wheels6 Ready HorserPower:$horsePower EngineCapacity:$engineCapacity")
    }
}