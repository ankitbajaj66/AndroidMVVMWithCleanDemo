package com.example.practice.kotlinscopefunction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidmvvmwithcleandemo.R

class KotlinExtensionFunction : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_extension_function)


        val testString: String? = "Hello"

        /**
         * let function
         *  Referenced by -> it
         *  Returns -> last statement
         *  Use case -> Null checks
         */
        testString?.let {
            it.toUpperCase().reversed()
        }


        /**
         * apply
         * Referenced by -> this
         * Returns -> same object
         * Use case -> Initialize and configure an object
         */
        val userData = UserData("Ankit", "TCS")

        println(userData.apply {
            setCompanyNew("Globant")
        })


        /**
         * also
         * Referenced by -> it
         * Returns -> same object
         * Use case -> Additional actions that don´t alter the object, such as logging debug info.
         */

        val ob = userData.apply {
            setCompanyNew("Globant")
        }.also {
            Log.i("Also Scope Function", "its just a log")
        }


        /**
         * run
         * Referenced by -> this
         * Returns -> last statement
         * It is the only scope function that has two variants.
         * 1.run as extension -> used to create a scope to run an operation over an object, and get a result.
         *
         * Note that run returns the last statement of the function.
         * So it is useful when you and need to run certain operations over an object,
         * and finally return one last operation, like the example.
         */

        val testStringRun: String? = "Hello"

        testStringRun?.run {
            reversed()
            length
        }


        /**
         * run
         * Referenced by -> this
         * Returns -> last statement
         * It is the only scope function that has two variants.
         * 2. run as function -> reduce the scope of certain variables, to avoid unnecessary access.
         *
         * userData1 will not be accessed from outside
         */

        run {
            val userData1 = UserData("Ankit", "TCS")
            userData.name
        }

        /**
         * with
         * Referenced by -> this
         * Returns -> last statement
         * Use case -> Run multiple operations on an object
         */

        with(userData)
        {
            userData.name
        }
    }
}


