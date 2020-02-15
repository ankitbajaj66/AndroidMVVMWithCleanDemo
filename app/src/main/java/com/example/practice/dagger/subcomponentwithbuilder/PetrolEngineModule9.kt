package com.example.practice.dagger.subcomponentwithbuilder

import dagger.Binds
import dagger.Module

/**
 *Created by Ankit Bajaj on 12-02-2020.
 */
@Module
abstract class PetrolEngineModule9 {

    @Binds
    abstract fun bindsEngine(petrolEngine9: PetrolEngine9): Engine9
}