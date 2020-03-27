package com.example.uitestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.androidmvvmwithcleandemo.R

import kotlinx.android.synthetic.main.activity_first_ui_test.*

class FirstUiTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_ui_test)

        val num = arrayOf(1, 2, 3, 4 , 5, 6, 7, 8, 9 ,0)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, num)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = arrayAdapter
        spinner.setSelection(2)
    }
}
