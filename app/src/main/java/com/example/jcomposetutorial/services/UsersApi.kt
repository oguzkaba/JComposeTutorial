package com.example.jcomposetutorial.services

import com.example.jcomposetutorial.model.Users
import com.example.jcomposetutorial.util.Constants
import retrofit2.http.GET
import retrofit2.http.Headers

interface UsersApi {
    @Headers("xc-token: ${Constants.API_KEY}")
    @GET("Users")
    suspend fun getUsers(): Users
}