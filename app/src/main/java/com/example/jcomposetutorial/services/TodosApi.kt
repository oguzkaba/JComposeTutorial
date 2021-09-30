package com.example.jcomposetutorial.services

import com.example.jcomposetutorial.model.Todos
import com.example.jcomposetutorial.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers

interface TodosApi {
    @Headers("xc-token: $API_KEY")
    @GET("Todo")
    suspend fun getTodos(): Todos
}