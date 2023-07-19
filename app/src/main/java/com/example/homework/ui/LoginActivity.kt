package com.example.homework.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework.databinding.ActivityLoginBinding
import com.example.homework.databinding.ActivitySignUpBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityLoginBinding = ActivityLoginBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUp()
    }

    override fun setUp() {
        addCallBacks()
    }

    override fun addCallBacks (){
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
            this.toast("PLS Enter Valued Phone Number")
            return false
        }
        else if (password.length < 8){
            this.toast("PLS Enter 8 char of password")
            return false
        }

        this.toast("Login successfully")

        return true
    }

}