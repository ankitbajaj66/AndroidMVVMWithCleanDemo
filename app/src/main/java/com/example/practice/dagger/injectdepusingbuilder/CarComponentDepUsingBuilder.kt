package com.example.practice.dagger.injectdepusingbuilder

import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

/**
 *Created by Ankit Bajaj on 09-02-2020.
 */
@Component(modules = [DieselEngineProvider6::class])
interface CarComponentDepUsingBuilder {
    fun getCar6(): Car6

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun horsePower(@Named("horserPower")horserPower: Int): Builder

        @BindsInstance
        fun engineCapacity(@Named("engineCapacity")engineCapacity: Int) : Builder

        fun build(): CarComponentDepUsingBuilder

    }
}