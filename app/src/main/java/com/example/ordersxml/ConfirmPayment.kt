package com.example.ordersxml

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.ordersxml.databinding.FragmentConfirmPaymentBinding
import com.example.ordersxml.databinding.OrderScreenBinding

class ConfirmPayment : DialogFragment(R.layout.fragment_confirm_payment) {
    private var binding: FragmentConfirmPaymentBinding? = null
    private var navController: NavController? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentConfirmPaymentBinding.bind(view)
        navController = Navigation.findNavController(view)

        binding!!.yesButton.setOnClickListener {
            navController!!.navigate(R.id.action_confirmPayment_to_orders)
        }
        binding!!.noButton.setOnClickListener {
            navController!!.navigate(R.id.action_confirmPayment_to_orderScreen)
        }
        }

}