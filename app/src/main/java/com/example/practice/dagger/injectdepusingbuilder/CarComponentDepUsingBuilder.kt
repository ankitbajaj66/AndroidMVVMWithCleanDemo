package com.example.practice.dagger.injectdepusingbuilder

import dagger.BindsInstance
import dagger.Component

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
@Component(modules = [DieselEngineProvider6::class])
interface CarComponentDepUsingBuilder {
    fun getCar6(): Car6

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun horsePower(horserPower: Int): Builder

        fun build(): CarComponentDepUsingBuilder

    }
}