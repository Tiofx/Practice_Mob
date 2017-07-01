package com.example.st_pov.practice.kotlin

import android.app.Activity
import android.content.Intent
import android.widget.Toast

fun Activity.showText(text: String, duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, text, duration)
                .show()

inline fun <reified T> Activity.loadActivity() = startActivity(Intent(this, T::class.java))


object Constants {
    const val MIN_PASSWORD_NUMBER = 8
    const val MAX_PASSWORD_NUMBER = 40
}