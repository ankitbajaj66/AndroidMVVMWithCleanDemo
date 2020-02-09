package com.example.practice.dagger.daggeroutsidedep

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmvvmwithcleandemo.R

class DaggerOutsideDepActivity : AppCompatActivity() {

    lateinit var car1: Car1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_outside_dep)


        val carComponentOutsideDep = DaggerCarComponentOutsideDep.create()

        car1 = carComponentOutsideDep.getCar()

        car1.run()
    }
}
