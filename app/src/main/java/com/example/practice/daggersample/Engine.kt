package com.example.practice.daggersample

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
class Engine @Inject constructor() {

    init {
        println("Engine constructor")
    }
}