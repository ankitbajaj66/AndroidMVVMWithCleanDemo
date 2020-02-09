package com.example.practice.dagger.injectdepusingbuilder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmvvmwithcleandemo.R

class InjectDepUsingBuilderActivity : AppCompatActivity() {

    lateinit var car6: Car6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inject_dep_using_builder2)

        val carComponentDepUsingBuilder =
            DaggerCarComponentDepUsingBuilder.builder().horsePower(20).build()

        car6 = carComponentDepUsingBuilder.getCar6()

        car6.ready()
    }
}
