package com.example.ordersxml


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.ordersxml.databinding.FragmentConfirmPaymentBinding

class ConfirmPayment : DialogFragment() {
    private var binding: FragmentConfirmPaymentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConfirmPaymentBinding.inflate(inflater, container, false)
        return binding?.root
    }

}
