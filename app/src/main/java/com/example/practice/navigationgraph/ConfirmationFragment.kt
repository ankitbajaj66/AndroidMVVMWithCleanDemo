package com.example.practice.navigationgraph


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.androidmvvmwithcleandemo.R
import com.example.practice.navigationgraph.data.Money
import kotlinx.android.synthetic.main.fragment_confirmation.*

/**
 * A simple [Fragment] subclass.
 */
class ConfirmationFragment : Fragment() {
    lateinit var recipientName: String
    lateinit var money: Money

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipientName = arguments!!.getString("recipient")
        money = arguments!!.getParcelable("amount")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val amount = money.amount
        val msg = "You have sent $amount to $recipientName"
        confirmation_message.text = msg
    }

}
