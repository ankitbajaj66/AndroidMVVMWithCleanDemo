package com.example.uitestpractice.fragmentuitest

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

/**
 *Created by Ankit Bajaj on 17-03-2020.
 */
class MovieFragmentFactory : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when (className) {
            MovieDetailFragment::class.java.name -> MovieDetailFragment()
            StarActorsFragment::class.java.name -> StarActorsFragment()
            DirectorsFragment::class.java.name -> MovieDetailFragment()
            else -> super.instantiate(classLoader, className)
        }


}