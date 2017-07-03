package com.example.st_pov.practice.service

import com.example.st_pov.practice.models.Feedback
import com.example.st_pov.practice.models.Hotel
import com.example.st_pov.practice.models.Room
import com.example.st_pov.practice.models.User
import retrofit2.Call
import retrofit2.http.*

//TODO: move our each interface to different file,  

interface UserApi {

    @POST("/user")
    fun registerUser(
            @Body user: User
    ): Call<Boolean>

    @GET("/user")
    fun validate(
            @Body user: User
    ): Call<Boolean>
}


interface HotelApi {

    @POST("/hotel")
    fun addHotel(
            @Body hotel: Hotel
    ): Call<Boolean>

    @GET("/hotels")
    fun getHotels(
            @Query("page") page: Int,
            @Query("per_page") perPage: Int
    ): Call<List<Hotel>>

    @GET("/hotels/best")
    fun getTheBestHotels(
            @Query("number") number: Int
    ): Call<List<Hotel>>
}


interface RoomApi {

    @POST("/hotels/{id}/room")
    fun addRoom(
            @Path("id") hotelId: Int,
            @Body room: Room
    ): Call<Boolean>

    @GET("/hotels/{id}/room")
    fun getRoom(
            @Path("id") hotelId: Int,
            @Query("id") roomId: Int
    ): Call<Room>

    @GET("/hotels/{id}/rooms")
    fun getAllRooms(
            @Path("id") hotelId: Int
    ): Call<List<Room>>
}


interface FeedbackApi {

    @POST("/hotels/{id}/feedback")
    fun giveFeedback(
            @Path("id") hotelId: Int,
            @Body feedback: Feedback
    ): Call<Boolean>

    @GET("/hotels/{id}/feedbacks")
    fun getFeedbacks(
            @Path("id") hotelId: Int,
            @Query("page") page: Int,
            @Query("per_page") perPage: Int
    ): Call<List<Feedback>>
}
