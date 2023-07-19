package com.example.homework.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.homework.databinding.ActivitySignUpBinding
import java.util.regex.Pattern


private lateinit var binding: ActivitySignUpBinding

class SignUpActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialEvents()

    }

    override fun initialEvents (){
        binding.signBt.setOnClickListener {
            if (checkFields())
                startActivity(Intent(this, MainActivity::class.java))
        }

        binding.loginTv.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.back.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    override fun checkFields(): Boolean {
        var phone = binding.phoneNumberEt.text.toString()
        var city = binding.cityEt.text.toString()
        var email = binding.emailEt.text.toString()
        var password = binding.passwordEt.text.toString()

        if (phone.isEmpty() || phone.length < 11){
            Toast.makeText(this, "PLS Enter Valid Phone Number", Toast.LENGTH_SHORT).show()
            return false
        }
        else if (password.length < 8){
            Toast.makeText(this, "PLS Enter 8 char of password", Toast.LENGTH_SHORT).show()
            return false
        }

        else if (city.isEmpty()){
            Toast.makeText(this, "PLS Enter City", Toast.LENGTH_SHORT).show()
            return false
        }

        val emailPatter = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"
        )

        if (!emailPatter.matcher(email).matches()){
            Toast.makeText(this, "PLS Enter valid Email", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!binding.checkbox.isChecked){
            Toast.makeText(this, "Make sure you that agree with our policy", Toast.LENGTH_SHORT).show()
            return false
        }

        Toast.makeText(this, "Welcome to our Application we're coming soon :)", Toast.LENGTH_SHORT).show()

        return true
    }

}