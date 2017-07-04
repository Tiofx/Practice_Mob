package com.example.st_pov.practice.util

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


inline fun <reified Api> sendToServer(response: Api.() -> Unit) =
        Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient(Constants.USER_AGENT))
                .build()
                .create(Api::class.java)
                .response()

fun getClient(userAgent: String) =
        OkHttpClient().apply {
            interceptors().add(Interceptor {
                it.request()
                        .newBuilder()
                        .header("User-Agent", userAgent)
                        .build()
                        .run { it.proceed(this) }
            })
        }

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