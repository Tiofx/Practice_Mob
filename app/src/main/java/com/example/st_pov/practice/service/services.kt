package com.example.st_pov.practice.service

import com.example.st_pov.practice.models.*
import retrofit2.Call
import retrofit2.http.*

//TODO: move our each interface to different file,  

interface UserApi {

    @POST("/user.json")
    fun registerUser(
            @Body user: User
    ): Call<Boolean>

    @GET("/user.json")
    fun signIn(
            @Query("email") email: String,
            @Query("password") password: String
    ): Call<AuthToken>

    @DELETE("/user.json")
    fun signOut(
    ): Call<Boolean>
}

interface HotelApi {

    @POST("/hotel.json")
    fun addHotel(
            @Body hotel: Hotel
    ): Call<Boolean>

    @GET("/hotels.json")
    fun getHotels(
            @Query("page") page: Int,
            @Query("per_page") perPage: Int
    ): Call<List<Hotel>>

    @GET("/hotels/best.json")
    fun getTheBestHotels(
            @Query("number") number: Int
    ): Call<List<Hotel>>

    @Deprecated("for testing")
    @GET("/hotels.json")
    fun getAllHotels(
    ): Call<List<Hotel>>
}


interface RoomApi {

    @POST("/hotels/{id}/room.json")
    fun addRoom(
            @Path("id") hotelId: Int,
            @Body room: Room
    ): Call<Boolean>

    @GET("/hotels/{id}/room.json")
    fun getRoom(
            @Path("id") hotelId: Int,
            @Query("id") roomId: Int
    ): Call<Room>

    @GET("/hotels/{id}/rooms.json")
    fun getRooms(
            @Query("page") page: Int,
            @Query("per_page") perPage: Int
    ): Call<List<Room>>

    @Deprecated("for testing")
    @GET("/hotels/{id}/rooms.json")
    fun getAllRooms(
            @Path("id") hotelId: Int
    ): Call<List<Room>>
}


interface FeedbackApi {

    @POST("/hotels/{id}/feedback.json")
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

    @Deprecated("for testing")
    @GET("/hotels/{id}/feedbacks.json")
    fun getAllRooms(
            @Path("id") hotelId: Int
    ): Call<List<Feedback>>
}
