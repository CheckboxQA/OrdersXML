package com.example.ordersxml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ordersxml.databinding.StartScreenBinding

class StartScreen : AppCompatActivity() {
    private lateinit var binding: StartScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StartScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.orderWithDelivery.setOnClickListener {
            val intent = Intent(this, OrderScreen::class.java)
            startActivity(intent)
        }
    }
}