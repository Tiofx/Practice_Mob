package com.example.st_pov.practice.kotlin

import android.app.Activity
import android.content.Intent
import android.widget.Toast

fun Activity.showText(text: String, duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, text, duration)
                .show()

inline fun <reified T> Activity.loadActivity() = startActivity(Intent(this, T::class.java))


object Constants {
    val NAME_LENGTH_RANGE = 2 to 20
    val PASSWORD_LENGTH_RANGE = 8 to 40
    val HOTEL_LENGTH_RANGE = 3 to 40
    val ADDRESS_LENGTH_RANGE = 3 to 100
    val FEEDBACK_LENGTH_RANGE = 3 to 300

    object Regex {
        val FIRST_NAME = NAME_LENGTH_RANGE.run { "^[A-Z|А-Я][a-z|а-я]{$first,$second}$" }
        val LAST_NAME = FIRST_NAME
        val PASSWORD = PASSWORD_LENGTH_RANGE.run { "^\\w.{$first,$second}$" }

        val ADDRESS = ADDRESS_LENGTH_RANGE.run { "^(.{0}|[А-Яа-я\\w\\s\\.]{$first,$second})$" }
        val HOTEL_TITLE = HOTEL_LENGTH_RANGE.run { "^[А-Яа-я\\w\\s]{$first,$second}$" }
        val FEEDBACK = FEEDBACK_LENGTH_RANGE.run { "^.{$first,$second}$" }
    }
}
