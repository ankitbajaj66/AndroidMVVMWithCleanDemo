package com.example.practice.dagger.interfacedependancy

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
class PetrolEngine : Engine2 {
    override fun engineReady() {
        println("PetrolEngine ready")
    }
}