package com.example.practice.dagger.daggerbindsanotation

import dagger.Component

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
@Component(modules = [DieselEngineProviderModule3::class])
interface CarComponentBindAnotation {
    fun getCar3(): Car3
}