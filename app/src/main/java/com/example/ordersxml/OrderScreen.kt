package com.example.ordersxml

import ProductAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ordersxml.databinding.OrderScreenBinding
import com.example.test.Product

class OrderScreen : AppCompatActivity() {
    private lateinit var binding: OrderScreenBinding
    private lateinit var viewModel: OrderViewModel
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.order_screen)

        viewModel = OrderViewModel(
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

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.deliveryDoneButton.setOnClickListener {
            val intent = Intent(this, StartScreen::class.java)
            startActivity(intent)
        }

        val productList = listOf(
            Product("Рістретто", null, "₴ 440.60", "2 х 220.30"),
            Product("Молоко", "12345948947", "₴ 98.60", "1 х 98.60"),
            Product("Рістретто", "3216754121", "₴ 55.60", "1 х 55.60"),
            Product("Рістретто", null, "₴ 440.75", "1 х 440.75")
        )

        setupRecyclerView(productList)
    }

    private fun setupRecyclerView(products: List<Product>) {
        adapter = ProductAdapter()
        binding.itemsList.adapter = adapter
        binding.itemsList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(products)
    }
}
