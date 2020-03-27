package com.example.practice.fragmentsdemo.fragmentfactorydemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidmvvmwithcleandemo.R
import kotlinx.android.synthetic.main.first_fragment.view.*

/**
 *Created by Ankit Bajaj on 17-03-2020.
 */
class FirstFragment(val strData:String) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.first_fragment, container, false)
        val textView = view.txt_sample

//        arguments?.let {
//
//            textView.text = it.getString("args_test_data")
//        }
        textView.text = strData
        return view
    }
}