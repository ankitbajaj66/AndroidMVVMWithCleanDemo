package com.example.practice.dagger.daggeroutsidedep

import dagger.Component

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
@Component(modules = [CarProvider::class])
interface CarComponentOutsideDep {
    fun getCar() : Car1
}