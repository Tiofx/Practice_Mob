package com.example.st_pov.practice.api

import com.example.st_pov.practice.models.Room
import retrofit2.Call
import retrofit2.http.*

interface RoomApi {
    @POST("/hotel/{id}/room")
    fun addRoom(@Path("id") hotelId: Int,
                @Body room: Room)
            : Call<Boolean>

    @GET("/hotel/{id}/room")
    fun getRoom(@Path("id") hotelId: Int,
                @Query("id") roomId: Int)
            : Call<Room>

    @GET("/hotel/{id}/rooms")
    fun getAllRooms(@Path("id") hotelId: Int)
            : Call<Array<Room>>
}