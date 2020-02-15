package com.example.practice.dagger.subcomponentwithbuilder

import javax.inject.Inject
import javax.inject.Named

/**
 *Created by Ankit Bajaj on 12-02-2020.
 */
class PetrolEngine9 @Inject constructor(@Named("engineCapacity") private val capacity: Int) : Engine9 {

    override fun ready() {
        println("Petrol Engine Ready with engine capacity $capacity")
    }
}