package com.example.st_pov.practice.models

import com.google.gson.annotations.SerializedName

data class AuthToken(
        @SerializedName("auth_token") var token: String?
)

data class SimpleResponse(
        @SerializedName("success") var success: Boolean
)