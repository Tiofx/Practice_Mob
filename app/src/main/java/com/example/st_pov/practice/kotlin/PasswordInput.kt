package com.example.st_pov.practice.kotlin

import android.view.View
import kotlinx.android.synthetic.main.password_input.view.*

class PasswordInput(var passwordContainer: View) {
    val password
        get() = passwordContainer.password

    init {
        passwordContainer.show_btn
                .setOnClickListener { showPassword() }
    }

    fun showPassword() = 0F
}