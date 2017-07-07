package com.example.st_pov.practice.service

import com.example.st_pov.practice.models.AuthToken
import com.example.st_pov.practice.models.Feedback
import com.example.st_pov.practice.models.Hotel
import com.example.st_pov.practice.models.User
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
            @Body hotel: Hotel
    ): Call<Boolean>

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


//interface RoomApi {
//
//    @POST("/api/v${Constants.VERSION}/hotels/{id}/room")
//    fun addRoom(
//            @Path("id") hotelId: Int,
//            @Body room: Room
//    ): Call<Boolean>
//
//    @GET("/api/v${Constants.VERSION}/hotels/{id}/room")
//    fun getRoom(
//            @Path("id") hotelId: Int,
//            @Query("id") roomId: Int
//    ): Call<Room>
//
//    @GET("/api/v${Constants.VERSION}/hotels/{id}/rooms")
//    fun getRooms(
//            @Query("page") page: Int,
//            @Query("per_page") perPage: Int
//    ): Call<List<Room>>
//
//    @Deprecated("for testing")
//    @GET("/api/v${Constants.VERSION}/hotels/{id}/rooms")
//    fun getAllRooms(
//            @Path("id") hotelId: Int
//    ): Call<List<Room>>
//}


interface FeedbackApi {

    @POST("/api/v${Constants.VERSION}/reviews/{id}")
    fun giveFeedback(
            @Path("id") hotelId: Int,
            @Body feedback: Feedback
    ): Call<Boolean>

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
