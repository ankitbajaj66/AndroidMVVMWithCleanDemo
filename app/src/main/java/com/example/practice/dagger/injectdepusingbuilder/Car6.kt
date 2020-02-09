package com.example.practice.dagger.injectdepusingbuilder

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
class Car6 @Inject constructor(private val wheels6: Wheels6, private val engine6: Engine6) {

    fun ready()
    {
        wheels6.ready()
        engine6.ready()
    }
}