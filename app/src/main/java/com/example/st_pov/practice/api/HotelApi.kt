package com.example.st_pov.practice.api

import com.example.st_pov.practice.models.Hotel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface HotelApi {
    @POST("/hotel")
    fun addHotel(@Body hotel: Hotel): Call<Boolean>

    @GET("/hotels")
    fun getHotels(@Query("pageNumber") pageNumber: Int,
                  @Query("pageSize") pageSize: Int)
            : Call<Array<Hotel>>

    @GET("/hotels/best")
    fun getTheBestHotels(@Query("number") number: Int)
}