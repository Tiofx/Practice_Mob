package com.example.st_pov.practice.models

import com.google.gson.annotations.SerializedName

//TODO: modify
data class User(
        @SerializedName("id") var id: Int? = null,
        @SerializedName("email") var email: String,
        @SerializedName("password") var password: String,
        @SerializedName("full_name") var fullName: String? = null
)

data class Hotel(
        @SerializedName("id") var id: Int? = null,
        @SerializedName("name") var title: String,
        @SerializedName("star") var starRating: Int,
        @SerializedName("breakfast") var hasBreakfast: Boolean? = false,
        @SerializedName("address") var address: String? = null,
        @SerializedName("photo") var photo: Int? = null,
        @SerializedName("price") var price: Int? = null,
        @SerializedName("description") var roomDescription: String? = null,
        @SerializedName("room") var room: String? = null,
        @SerializedName("reviews_number") var reviewsNumber: Int = 0
) {
    constructor(title: String, address: String?, reviewsNumber: Int,
                photo: Int?, starRating: Int, hasBreakfast: Boolean?)
            : this(null, title = title, address = address,
            photo = photo, starRating = starRating, hasBreakfast = hasBreakfast)
}

//data class Room(
//        @SerializedName("id") var id: Int? = null,
//        @SerializedName("hotel_id") var hotelId: Int,
//        @SerializedName("price") var price: Int,
//        @SerializedName("description") var description: String
//)

data class Feedback(
        @SerializedName("id") var id: Int? = null,
        @SerializedName("hotel_id") var hotelId: Int? = null,
        //TODO: define by token on server
//        @SerializedName("user_id") var userId: Int? = null,
        @SerializedName("review") var comment: String,
        @SerializedName("rate") var rating: Int
)
