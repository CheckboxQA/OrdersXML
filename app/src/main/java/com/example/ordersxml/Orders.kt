package com.example.ordersxml

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ordersxml.databinding.OrdersListScreenBinding
import androidx.navigation.NavController
import androidx.navigation.Navigation

class Orders : Fragment(R.layout.orders_list_screen) {
    private var binding: OrdersListScreenBinding? = null
    private var adapter: OrderAdapter? = null
    private var navController: NavController? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = OrdersListScreenBinding.bind(view)
        navController = Navigation.findNavController(view)

        val firstOrder = Order(
                id = "1",
                address = "Some address",
                phoneNumber = "1234567890",
                recipient = "John Doe",
                comment = "Some comment",
                numberAndData = "123 / 2023-08-15",
                deliverySpot = "Some delivery spot",
                boxNumber = "123",
                paymentType = "Credit Card",
                delivery = false
        )
        val  secondOrder = Order(
                id = "2",
                address = "Another address",
                phoneNumber = "9876543210",
                recipient = "Jane Smith",
                comment = "Another comment",
                numberAndData = "456 / 2023-08-18",
                deliverySpot = "Another delivery spot",
                boxNumber = "456",
                paymentType = "Cash",
                delivery = true
        )
        val ordersList = listOf(firstOrder, secondOrder)
        binding!!.lifecycleOwner = this

        setupRecyclerView(ordersList)
    }

    private fun setupRecyclerView(ordersList: List<Order>) {
        adapter = OrderAdapter { order ->
            navController?.navigate(R.id.action_orders_to_orderScreen)
        }
        binding!!.ordersList.adapter = adapter
        binding!!.ordersList.layoutManager = LinearLayoutManager(requireContext())
        adapter!!.submitList(ordersList)
    }
    }

