package com.example.homework.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework.databinding.ActivityMainBinding

private lateinit var binding :ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.refresh.setOnClickListener {
        startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}