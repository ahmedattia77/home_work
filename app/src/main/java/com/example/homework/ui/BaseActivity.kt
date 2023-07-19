package com.example.homework.ui

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun checkFields():Boolean
    abstract fun initialEvents ():Unit

}