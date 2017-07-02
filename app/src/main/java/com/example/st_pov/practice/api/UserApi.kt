package com.example.st_pov.practice.api

import com.example.st_pov.practice.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {
    @POST("/user")
    fun registerUser(@Body user: User): Call<Boolean>

    @GET("/user")
    fun validate(user: User): Call<Boolean>
}