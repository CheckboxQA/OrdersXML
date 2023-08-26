package com.example.ordersxml

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ordersxml.databinding.OrdersListScreenBinding

class Orders : AppCompatActivity() {
    private var binding: OrdersListScreenBinding? = null
    private var adapter: OrderAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.orders_list_screen)

        val firstOrder = OrderViewModel(
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
        val  secondOrder = OrderViewModel(
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
    private fun setupRecyclerView(ordersList: List<OrderViewModel>) {
        adapter = OrderAdapter()
        binding!!.ordersList.adapter = adapter
        binding!!.ordersList.layoutManager = LinearLayoutManager(this)
        adapter!!.submitList(ordersList.toMutableList())
        Log.d("OrdersList", "Order list size: ${ordersList.size}")
    }
    }
