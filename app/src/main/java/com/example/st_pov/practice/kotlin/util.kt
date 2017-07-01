package com.example.st_pov.practice.kotlin

fun android.app.Activity.showText(text: String, duration: Int = android.widget.Toast.LENGTH_SHORT) =
        android.widget.Toast.makeText(this, text, duration)
                .show()

inline fun <reified T> android.app.Activity.loadActivity() = startActivity(android.content.Intent(this, T::class.java))