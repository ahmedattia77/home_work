package com.example.homework.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.homework.databinding.ActivityLoginBinding

private lateinit var binding: ActivityLoginBinding

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialEvents()

    }

    override fun initialEvents (){
        binding.loginBt.setOnClickListener {

            if (checkFields())
                startActivity(Intent(this, MainActivity::class.java))
        }

        binding.signUpTv.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    override fun checkFields() : Boolean {
        var phone = binding.phoneNumberEt.text.toString()
        var password = binding.passwordEt.text.toString()

        if (phone.isEmpty() || phone.length < 11){
            Toast.makeText(this, "PLS Enter Valued Phone Number", Toast.LENGTH_SHORT).show()
            return false
        }
        else if (password.length < 8){
            Toast.makeText(this, "PLS Enter 8 char of password", Toast.LENGTH_SHORT).show()
            return false
        }

        Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show()

        return true
    }

}