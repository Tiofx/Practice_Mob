package com.example.st_pov.practice.kotlin

import android.app.Activity
import android.content.Intent
import android.widget.Toast

fun Activity.showText(text: String, duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, text, duration)
                .show()

inline fun <reified T> Activity.loadActivity() = startActivity(Intent(this, T::class.java))


object Constants {
    const val MIN_PASSWORD_LENGTH = 8
    const val MAX_PASSWORD_LENGTH = 40

    const val MIN_NAME_LENGTH = 3
    const val MAX_NAME_LENGTH = 20

    const val MIN_HOTEL_TITLE_LENGTH = 3
    const val MAX_HOTEL_TITLE_LENGTH = 40

    const val MIN_FEEDBACK_LENGTH = 3
    const val MAX_FEEDBACK_LENGTH = 300

    val FEEDBACK_RANGE = 3 to 400
}