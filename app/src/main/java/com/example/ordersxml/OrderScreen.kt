package com.example.ordersxml

import ProductAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ordersxml.databinding.OrderScreenBinding
import com.example.ordersxml.databinding.OrdersListScreenBinding

class OrderScreen : Fragment(R.layout.order_screen) {
    private var binding: OrderScreenBinding? = null
    private var adapter: ProductAdapter? = null
    private var navController: NavController? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = OrderScreenBinding.bind(view)
        navController = Navigation.findNavController(view)

        val orderModel = Order(
            id = "1",
            address = "Some address",
            phoneNumber = "1234567890",
            recipient = "John Doe",
            comment = "Some comment",
            numberAndData = "123 / 2023-08-15",
            deliverySpot = "Some delivery spot",
            boxNumber = "123",
            paymentType = "Credit Card",
            delivery = true
        )

        binding!!.dataModel = orderModel
        binding!!.lifecycleOwner = this

        val productList = listOf(
            Product("1","Рістретто", null, "₴ 440.60", "2 х 220.30"),
            Product("2","Молоко", "12345948947", "₴ 98.60", "1 х 98.60"),
            Product("3","Кава", "3216754121", "₴ 55.60", "1 х 55.60"),
            Product("4","Чай", null, "₴ 440.75", "1 х 440.75")
        )

        setupRecyclerView(productList)
    }

    private fun setupRecyclerView(products: List<Product>) {
        adapter = ProductAdapter()
        binding!!.itemsList.adapter = adapter
        binding!!.itemsList.layoutManager = LinearLayoutManager(requireContext())
        adapter!!.submitList(products)
        Log.d("OrderScreen", "Product list size: ${products.size}")
    }
}
