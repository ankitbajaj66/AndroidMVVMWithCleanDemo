package com.example.practice.navigationgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.androidmvvmwithcleandemo.R
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // This NavController have reference to navgraph
        // With the Fragment Main which is present inside nav graph has access to nav graph, we can get it
        navController = Navigation.findNavController(view)

        view_transactions_btn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
        }
        send_money_btn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
        }
        view_balance_btn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }
    }

}
