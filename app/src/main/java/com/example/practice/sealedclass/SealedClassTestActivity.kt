package com.example.practice.sealedclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidmvvmwithcleandemo.R
import kotlinx.android.synthetic.main.activity_sealed_class_test.*

class SealedClassTestActivity : AppCompatActivity() {

    lateinit var sealedClassViewModel: SealedClassViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sealed_class_test)

        sealedClassViewModel = ViewModelProviders.of(this).get(SealedClassViewModel::class.java)

        sealedClassViewModel.state.observe(this, Observer {
            render(it)
        })

//        sealedClassViewModel.fetchFirstThreeStates()

        btn_get_values.setOnClickListener {
            sealedClassViewModel.fetchFirstThreeStates()
        }
    }


    override fun onResume() {
        super.onResume()
        sealedClassViewModel.fetchFirstThreeStates()
    }

    fun render(state: SealedClassViewModel.State) {
        when (state) {
            is SealedClassViewModel.State.One -> display(state.data1)
            is SealedClassViewModel.State.Two -> display(state.data2)
            is SealedClassViewModel.State.Three -> display(state.data3)
        }
    }

    fun display(data: String) {
        println("values from server " + data)
    }
}
