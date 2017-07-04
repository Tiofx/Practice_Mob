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
        passwordContainer.show_btn.setOnClickListener { switchState() }

//        show_btn.setOnTouchListener(View.OnTouchListener { v, event ->
//            when (event.action) {
//                MotionEvent.ACTION_DOWN -> password.inputType = InputType.TYPE_CLASS_TEXT
//                MotionEvent.ACTION_UP -> password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
//            }
//            true
//        })
    }

    fun switchState() {
        isPasswordVisible = isPasswordVisible.not()
    }
}