package com.example.st_pov.practice.util

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.example.st_pov.practice.models.Feedback
import com.example.st_pov.practice.models.User
import com.example.st_pov.practice.service.FeedbackApi
import com.example.st_pov.practice.service.UserApi
import retrofit2.Response

fun Activity.showText(text: String, duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, text, duration)
                .show()

inline fun <reified T> Activity.loadActivity() = loadActivity(T::class.java)

fun Activity.loadActivity(loadActivityClass: Class<*>) =
        startActivity(Intent(this, loadActivityClass))

object Session {
    var tokenValue: String? = null
    var currentUser: User? = null
}


//TODO: move out into file
object Constants {
    //TODO: change on release
    const val BASE_URL = "http://divine-leaf-1414.getsandbox.com"

    const val USER_AGENT = "mobile_android"
    const val TOKEN_NAME = "token"


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


fun <T> Response<T>?.simpleResponseParser(onNoBody: String = "Тело ответа отсутствует",
                                          parseBody: T.() -> String) =
        this?.let {
            if (it.isSuccessful)
                it.body()?.parseBody() ?: onNoBody
            else "Произошла ошибка ${it.code()}"
        } ?: "Ошибка на строне сервера"


inline fun UserApi.validate(user: User) =
        user.run { validate(email, password) }

inline fun FeedbackApi.giveFeedback(feedback: Feedback)
        = feedback.run { giveFeedback(hotelId!!, feedback) }