package com.example.practice.dagger.daggersubcomponent

import com.example.practice.dagger.daggersingleton.PerActiivty8
import dagger.Subcomponent

/**
 *Created by Ankit Bajaj on 11-02-2020.
 */
@PerActiivty8
@Subcomponent
interface PerActivityComponent8 {
    fun getCar(): Car8
}