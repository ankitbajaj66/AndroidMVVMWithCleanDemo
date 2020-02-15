package com.example.practice.dagger.subcomponentwithbuilder

import com.example.practice.dagger.daggersingleton.PerActiivty9
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Named

/**
 *Created by Ankit Bajaj on 11-02-2020.
 */
@PerActiivty9
@Subcomponent(modules = [PetrolEngineModule9::class])
interface PerActivityComponent9 {
    fun getCar(): Car9

    @Subcomponent.Builder
    interface Builder
    {
        @BindsInstance
        fun engineCapacity(@Named("engineCapacity") engineCapacity:Int) : Builder

        fun build() : PerActivityComponent9
    }
}