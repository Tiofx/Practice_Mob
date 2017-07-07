package com.example.st_pov.practice.service

import com.example.st_pov.practice.models.*
import com.example.st_pov.practice.util.Constants
import retrofit2.Call
import retrofit2.http.*


interface UserApi {

    @POST("/api/v${Constants.VERSION}/users")
    fun registerUser(
            @Body user: User
    ): Call<Boolean>

    @GET("/api/v${Constants.VERSION}/users")
    fun signIn(
            @Query("email") email: String,
            @Query("password") password: String
    ): Call<AuthToken>

    @DELETE("/api/v${Constants.VERSION}/users")
    fun signOut(
    ): Call<Boolean>
}


interface HotelApi {

    @POST("/api/v${Constants.VERSION}/hotels")
    fun addHotel(
            @Query("name") name: String,
            @Query("breakfest") breakfest: Boolean?,
            @Query("star") star: Int,
            @Query("address") address: String?,
            @Query("room") room: String?,
            @Query("price") price: Int?,
            @Query("description") description: String?
    ): Call<SimpleResponse>

    @GET("/api/v${Constants.VERSION}/hotels")
    fun getHotels(
            @Query("page") page: Int,
            @Query("per_page") perPage: Int
    ): Call<List<Hotel>>

    @GET("/api/v${Constants.VERSION}/hotels/best")
    fun getTheBestHotels(
            @Query("number") number: Int
    ): Call<List<Hotel>>

    @Deprecated("for testing")
    @GET("/api/v${Constants.VERSION}/hotels")
    fun getAllHotels(
    ): Call<List<Hotel>>
}

interface FeedbackApi {

    @POST("/api/v${Constants.VERSION}/reviews/{id}")
    fun giveFeedback(
            @Query("rate") rate: Int,
            @Query("review") review: String,
            @Query("hotel_id") hotelId: Int
    ): Call<SimpleResponse>


    @GET("/api/v${Constants.VERSION}/reviews/{id}")
    fun getFeedbacks(
            @Path("id") hotelId: Int,
            @Query("page") page: Int,
            @Query("per_page") perPage: Int
    ): Call<List<Feedback>>

    @Deprecated("for testing")
    @GET("/api/v${Constants.VERSION}/reviews/{id}")
    fun getAllFeedbacks(
            @Path("id") hotelId: Int
    ): Call<List<Feedback>>
}
