package com.example.st_pov.practice.api

import com.example.st_pov.practice.models.Feedback
import retrofit2.Call
import retrofit2.http.*


interface FeedbackApi {
    @POST("/hotel/{id}/feedback")
    fun giveFeedback(@Path("id") hotelId: Int,
                     @Body feedback: Feedback)
            : Call<Boolean>

    @GET("/hotel/{id}/feedbacks")
    fun getFeedbacks(@Path("id") hotelId: Int,
                     @Query("pageNumber") pageNumber: Int,
                     @Query("pageSize") pageSize: Int)
            : Call<Array<Feedback>>
}