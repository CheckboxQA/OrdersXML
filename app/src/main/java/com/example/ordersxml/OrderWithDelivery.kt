package com.example.ordersxml

import ProductAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ordersxml.databinding.OrderWithDeliveryBinding
import com.example.test.Product

class OrderWithDelivery : AppCompatActivity() {
    private lateinit var binding: OrderWithDeliveryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OrderWithDeliveryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.deliveryDoneButton.setOnClickListener{
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
        val recyclerView: RecyclerView = findViewById(R.id.items_list)
        val adapter = ProductAdapter(products)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}