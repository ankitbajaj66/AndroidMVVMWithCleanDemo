package com.example.practice.dagger.interfacedependancy

import dagger.Component

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
@Component(modules = [PetrolEngineProvider::class])
interface CarComponentInterfaceDep {
    fun getCar() : Car2
}