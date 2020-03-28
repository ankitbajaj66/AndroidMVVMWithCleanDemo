package com.example.practice.navigationgraph


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.androidmvvmwithcleandemo.R
import com.example.practice.navigationgraph.data.Money
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 */
class SpecifyAmountFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var recipientName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipientName = arguments!!.getString("recipient")

        arguments?.let {
            val specifyAmountFragmentArgs = SpecifyAmountFragmentArgs.fromBundle(it)
            recipientName = specifyAmountFragmentArgs.recipient
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        recipient.text = "Sending Money to $recipientName"
        send_btn.setOnClickListener {
            if (!TextUtils.isEmpty(input_amount.text.toString())) {
                val amount = Money(BigDecimal(input_amount.text.toString()))
                /*val bundle = bundleOf("recipient" to recipientName, "amount" to amount)
                navController.navigate(
                    R.id.action_specifyAmountFragment_to_confirmationFragment,
                    bundle
                )*/

                val action: SpecifyAmountFragmentDirections.ActionSpecifyAmountFragmentToConfirmationFragment =
                    SpecifyAmountFragmentDirections.actionSpecifyAmountFragmentToConfirmationFragment(
                        amount
                    )
                action.recipient = recipientName

                navController.navigate(action)
            } else {
                Toast.makeText(activity, "Please Enter Amount", Toast.LENGTH_LONG).show()
            }

        }

        cancel_btn.setOnClickListener {
            activity!!.onBackPressed()
        }

    }
}
