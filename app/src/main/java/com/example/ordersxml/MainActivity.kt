package com.example.ordersxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ordersxml.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private var binding: MainActivityBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)
    }
}