package com.example.st_pov.practice.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.st_pov.practice.models.Feedback
import com.example.st_pov.practice.models.Hotel
import com.example.st_pov.practice.models.User
import com.example.st_pov.practice.service.FeedbackApi
import com.example.st_pov.practice.service.HotelApi
import com.example.st_pov.practice.service.UserApi
import retrofit2.Response

object Session {
    var currentUser: User? = null
        set(value) {
//            if (value == null) {
//                tokenValue = null
//                sendToServer<UserApi> {
//                    signOut().enqueue(FunctionalCallback<Boolean>(
//                            { _, response ->
//                                response?.let {
//                                    it.takeIf { it.isSuccessful }
//                                            ?.body()
//                                            ?.let { field = value }
//                                }
//                            }
//                    ))
//                }
//            } else {
                field = value
//            }
        }

    var tokenValue: String? = null
}

//TODO: move out into config file
object Constants {
    const val VERSION = 1

    const val BASE_URL = "https://hotelite.herokuapp.com"
    const val USER_AGENT = "mobile_android"
    const val TOKEN_NAME = "auth_token"
    const val HOTEL_REQUEST_CODE = 1
    val NAME_LENGTH_RANGE = 2 to 20


    val PASSWORD_LENGTH_RANGE = 8 to 40
    val HOTEL_LENGTH_RANGE = 3 to 40
    val ADDRESS_LENGTH_RANGE = 3 to 100
    val FEEDBACK_LENGTH_RANGE = 3 to 300

    object Regex {

        val FIRST_NAME = NAME_LENGTH_RANGE.run { "^[A-Z|А-Я][a-z|а-я]{${first - 1},$second}$" }
        val LAST_NAME = FIRST_NAME
        val PASSWORD = PASSWORD_LENGTH_RANGE.run { "^\\w.{$first,$second}$" }
        val ADDRESS = ADDRESS_LENGTH_RANGE.run { "^(.{0}|[А-Яа-я\\w\\s\\.]{$first,$second})$" }

        val HOTEL_TITLE = HOTEL_LENGTH_RANGE.run { "^[А-Яа-я\\w\\s]{$first,$second}$" }
        val FEEDBACK = FEEDBACK_LENGTH_RANGE.run { "^.{$first,$second}$" }
    }
}


fun Context.showText(text: String, duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, text, duration)
                .show()

inline fun <reified T> Activity.loadActivity(noinline intentConfig: Intent.() -> Unit = {}) {
    Intent(this, T::class.java).apply {
        intentConfig()
        startActivity(this)
    }
}

fun Context.loadActivity(loadActivityClass: Class<*>) =
        startActivity(Intent(this, loadActivityClass))


fun <T> Response<T>?.simpleResponseParser(onNoBody: String = "Тело ответа отсутствует",
                                          parseBody: T.() -> String) =
        this?.let {
            if (it.isSuccessful)
                it.body()?.parseBody() ?: onNoBody
            else "Произошла ошибка ${it.code()}"
        } ?: "Ошибка на строне сервера"


inline fun UserApi.signIn(user: User) =
        user.run { signIn(email, password) }

inline fun FeedbackApi.giveFeedback(feedback: Feedback)
        = feedback.run { giveFeedback(hotelId!!, feedback) }

inline fun HotelApi.addHotel(hotel: Hotel) = hotel.run {
    this@addHotel.addHotel(title,
            hasBreakfast,
            starRating,
            address,
            roomDescription,
            price,
            roomDescription)
}


inline fun FeedbackApi.giveFeedback(hotelId: Int, feedback: Feedback)
        = feedback.run { giveFeedback(rating, comment, hotelId) }