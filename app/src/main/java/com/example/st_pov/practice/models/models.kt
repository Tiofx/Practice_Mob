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
        @SerializedName("title") var title: String,
        @SerializedName("star_rating") var starRating: Int,
        @SerializedName("has_breakfast") var hasBreakfast: Boolean? = null,
        @SerializedName("address") var address: String? = null,
        @SerializedName("photo") var photo: Int? = null,
        //        @SerializedName("photo") var photo: Image? = null,
        @SerializedName("reviews_number") var reviewsNumber: Int = 0,
        @SerializedName("rooms") var rooms: List<Room>? = null
) {
    constructor(title: String, address: String?, reviewsNumber: Int,
                photo: Int?, starRating: Int, hasBreakfast: Boolean?)
            : this(null, title = title, address = address, reviewsNumber = reviewsNumber,
            photo = photo, starRating = starRating, hasBreakfast = hasBreakfast)
}

data class Room(
        @SerializedName("id") var id: Int? = null,
        @SerializedName("hotel_id") var hotelId: Int,
        @SerializedName("price") var price: Int,
        @SerializedName("description") var description: String
)

data class Feedback(
        @SerializedName("id") var id: Int? = null,
        @SerializedName("hotel_id") var hotelId: Int? = null,
        //TODO: define by token on server
//        @SerializedName("user_id") var userId: Int? = null,
        @SerializedName("comment") var comment: String,
        @SerializedName("rating") var rating: Int
)
