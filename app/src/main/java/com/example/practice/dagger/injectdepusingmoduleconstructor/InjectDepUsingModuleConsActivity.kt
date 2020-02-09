package com.example.practice.dagger.injectdepusingmoduleconstructor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmvvmwithcleandemo.R
import com.example.practice.dagger.injectdepusingbuilder.DaggerCarComponentDepUsingBuilder

class InjectDepUsingModuleConsActivity : AppCompatActivity() {

    lateinit var car5: Car5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inject_dep_using_builder)

        /* val carComponentDepUsingBuilder = DaggerCarComponentDepUsingBuilder.create()
         car5 = carComponentDepUsingBuilder.getCar5()

         car5.ready()*/

        val carComponentDepUsingBuilder = DaggerCarComponentDepUsingModuleCons.builder()
            .dieselEngineProvider5(DieselEngineProvider5(10)).build()

        car5 = carComponentDepUsingBuilder.getCar5()

        car5.ready()
    }
}
