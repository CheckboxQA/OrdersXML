package com.example.ordersxml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class OrderWithDelivery : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_with_delivery)
        deliveryDone()
    }

    fun deliveryDone(){
        findViewById<AppCompatButton>(R.id.delivery_done_button).setOnClickListener {
            val intent = Intent(this, StartScreen::class.java)
            startActivity(intent)
        }
    }
}