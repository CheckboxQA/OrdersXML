package com.example.ordersxml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ordersxml.databinding.OrderWithDeliveryBinding
import com.example.ordersxml.databinding.StartScreenBinding

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
    }

}