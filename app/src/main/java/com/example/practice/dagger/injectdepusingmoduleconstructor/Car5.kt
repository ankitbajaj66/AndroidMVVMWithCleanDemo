package com.example.practice.dagger.injectdepusingmoduleconstructor

import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
class Car5 @Inject constructor(private val wheels5: Wheels5, private val engine5: Engine5) {

    fun ready() {
        wheels5.ready()
        engine5.ready()
    }
}