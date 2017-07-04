package com.example.st_pov.practice.util

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun Activity.showText(text: String, duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, text, duration)
                .show()

inline fun <reified T> Activity.loadActivity() = startActivity(Intent(this, T::class.java))


//TODO: move out into file
object Constants {
    //TODO: change on release
    const val BASE_URL = "http://falling-paper-6881.getsandbox.com"


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


inline fun <reified Api> sendToServer(response: Api.() -> Unit) =
        Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)
                .response()


class FunctionalCallback<T>(var onResponse: (call: Call<T>?, response: Response<T>?) -> Unit,
                            var onFailure: (call: Call<T>?, t: Throwable?) -> Unit = { _, _ -> })
    : Callback<T> {

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        onResponse.invoke(call, response)
    }

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        onFailure.invoke(call, t)
    }
}


fun <T> Response<T>?.simpleResponseParser(onNoBody: String = "Тело ответа отсутствует",
                                          parseBody: T.() -> String) =
        this?.let {
            if (it.isSuccessful)
                it.body()?.parseBody() ?: onNoBody
            else "Произошла ошибка ${it.code()}"
        } ?: "Ошибка на строне сервера"


