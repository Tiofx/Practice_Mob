package com.example.st_pov.practice.util

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun baseRetrofit() = Retrofit.Builder()
        .client(getClient(Constants.USER_AGENT))
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

inline fun <reified Api> sendToServer(response: Api.() -> Unit) =
        baseRetrofit()
                .create(Api::class.java)
                .response()


fun getClient(userAgent: String) = OkHttpClient.Builder()
        .addInterceptor {
            it.request()
                    .newBuilder()
                    .apply {
                        it.getUrlForNewQueryParam()
                                .takeUnless { Session.tokenValue.isNullOrBlank() }
                                ?.let { url(it) }
                    }
                    .header("User-Agent", userAgent)
                    .build()
                    .run { it.proceed(this) }
        }
        .build()

fun Interceptor.Chain.getUrlForNewQueryParam(key: String = Constants.TOKEN_NAME,
                                             value: String? = Session.tokenValue) =
        request().url()
                .newBuilder()
                .addQueryParameter(key, value)
                .build()


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