package com.example.homework.ui


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.example.homework.databinding.ActivitySignUpBinding
import java.util.regex.Pattern



class SignUpActivity() : BaseActivity<ActivitySignUpBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivitySignUpBinding = ActivitySignUpBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUp()
    }

    override fun setUp(){
        addCallBacks()
    }

    override fun addCallBacks (){
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
            this.toast("PLS Enter Valid Phone Number")
            return false
        }
        else if (password.length < 8){
            this.toast("PLS Enter 8 char of password")
            return false
        }

        else if (city.isEmpty()){
            this.toast("PLS Enter City")
            return false
        }

        val emailPatter = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"
        )

        if (!emailPatter.matcher(email).matches()){
            this.toast("PLS Enter valid Email")
            return false
        }

        if (!binding.checkbox.isChecked){
            this.toast("Make sure you that agree with our policy")
            return false
        }

        this.toast("Welcome to our Application we're coming soon :)")

        return true
    }

}