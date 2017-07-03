package com.example.st_pov.practice.models

import android.media.Image

//TODO: modify
data class User(var email: String,
                var password: String,
                var fullName: String? = null)

data class Hotel(var title: String,
                 var starRating: Int,
                 var address: String? = null,
                 var photo: Image? = null)

data class Room(var capacity: Int)

data class Feedback(var feedback: String,
                    var rating: Int)
