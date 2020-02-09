package com.example.practice.dagger.daggeroutsidedep

import dagger.Module
import dagger.Provides

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
@Module
class CarProvider {


    // made this method as static as no dep passed to this m
    companion object {
        @Provides
        fun getCar(): Car1 {
            return Car1()
        }
    }

}