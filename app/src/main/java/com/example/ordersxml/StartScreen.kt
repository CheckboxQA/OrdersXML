package com.example.ordersxml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class StartScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.strat_screen)
        orderWithDelivery()
        orderWithoutDelivery()
    }

    fun orderWithDelivery(){
        findViewById<AppCompatButton>(R.id.order_with_delivery).setOnClickListener{
            val intent = Intent(this, OrderWithDelivery::class.java)
            startActivity(intent)
        }
    }
    fun orderWithoutDelivery(){
        findViewById<AppCompatButton>(R.id.order_without_delivery).setOnClickListener{
            val intent = Intent(this, OrderWithoutDelivery::class.java)
            startActivity(intent)
        }
    }
}
