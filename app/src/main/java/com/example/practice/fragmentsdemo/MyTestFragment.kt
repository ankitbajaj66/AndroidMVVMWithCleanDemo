package com.example.practice.fragmentsdemo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.androidmvvmwithcleandemo.R
import kotlinx.android.synthetic.main.fragment_testdemo.view.*

/**
 * A simple [Fragment] subclass.
 */
class MyTestFragment : Fragment() {

    private var strData: String = ""
    private var numberData: Int = 0


    companion object {
        const val ARG_TEXT = "argsText"
        const val ARG_NUMBER = "argsNumber"

        fun newInstance(strData: String, numberData: Int): MyTestFragment {
            val myTestFragment = MyTestFragment()

            val bundle = Bundle()
            bundle.putString(ARG_TEXT, strData)
            bundle.putInt(ARG_NUMBER, numberData)

            myTestFragment.arguments = bundle
            return myTestFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_testdemo, container, false)
        val textView = view.txt_sample
        arguments?.let {
            strData = it.getString(ARG_TEXT)
            numberData = it.getInt(ARG_NUMBER)
        }
        textView.text = "$strData : $numberData"
        return view
    }

}
