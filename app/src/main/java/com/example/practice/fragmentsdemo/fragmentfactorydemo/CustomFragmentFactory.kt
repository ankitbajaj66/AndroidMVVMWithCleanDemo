package com.example.practice.fragmentsdemo.fragmentfactorydemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

/**
 *Created by Ankit Bajaj on 17-03-2020.
 */
class CustomFragmentFactory(val strData:String) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String) =

        when (className) {
            FirstFragment::class.java.name -> FirstFragment(strData)
            else -> super.instantiate(classLoader, className)
        }


}