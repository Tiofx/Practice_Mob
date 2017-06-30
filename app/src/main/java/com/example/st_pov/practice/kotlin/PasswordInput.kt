package com.example.st_pov.practice.kotlin

import android.view.View
import com.example.st_pov.practice.R.layout.password_input
import kotlinx.android.synthetic.main.password_input.view.*

class PasswordInput(var passwordInput: View) {
    val password
        get() = passwordInput.password

    init {
        passwordInput.show_btn
                .setOnClickListener { showPassword() }
    }

    fun showPassword() = 0F
}