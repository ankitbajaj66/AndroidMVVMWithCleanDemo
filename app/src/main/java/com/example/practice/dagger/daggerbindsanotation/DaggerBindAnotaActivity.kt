package com.example.practice.dagger.daggerbindsanotation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmvvmwithcleandemo.R

class DaggerBindAnotaActivity : AppCompatActivity() {

    lateinit var car3: Car3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_bind_anota)

        val carComponentBindAnotation = DaggerCarComponentBindAnotation.create()

        car3 = carComponentBindAnotation.getCar3()

        car3.ready()

    }
}
