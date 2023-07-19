package com.example.homework.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<base :ViewBinding>() : AppCompatActivity() {

    protected lateinit var binding : base
    protected abstract val bindingInflater: (LayoutInflater) -> base

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingInflater(layoutInflater)
        setContentView(binding.root)

    }

    protected fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    protected abstract fun checkFields():Boolean
    protected abstract fun addCallBacks ():Unit

    protected abstract fun setUp ()

}