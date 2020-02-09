package com.example.practice.dagger.daggersample

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
class Driver @Inject constructor() {

    init {
        println("Driver constructor")
    }
}