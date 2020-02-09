package com.example.practice.dagger.daggerbindsanotation

import dagger.Binds
import dagger.Module

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
@Module
abstract class DieselEngineProviderModule3 {
    @Binds
    abstract fun bindsEngine(dieselEngine3: DieselEngine3): Engine3
}