package com.example.practice.dagger.interfacedependancy

import dagger.Module
import dagger.Provides

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
@Module
class PetrolEngineProvider {

    @Provides
    fun getPetrolEngine(): Engine2 {
        return PetrolEngine()
    }
}