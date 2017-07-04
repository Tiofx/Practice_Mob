package com.example.st_pov.practice.kotlin

import android.text.InputType
import android.view.View
import kotlinx.android.synthetic.main.password_input.view.*

class PasswordInput(var passwordContainer: View) {
    private var isPasswordVisible: Boolean = false
        set(value) {
            field = value
            (if (value)
                "скрыть" to InputType.TYPE_CLASS_TEXT
            else
                "показать" to (InputType.TYPE_CLASS_TEXT or
                        InputType.TYPE_TEXT_VARIATION_PASSWORD))
                    .run {
                        show_btn.text = first
                        password.inputType = second
                    }
        }

    val password
        get() = passwordContainer.password

    val show_btn
        get() = passwordContainer.show_btn


    init {
        show_btn.setOnClickListener { switchState() }
    }

    fun switchState() {
        isPasswordVisible = isPasswordVisible.not()
    }
}