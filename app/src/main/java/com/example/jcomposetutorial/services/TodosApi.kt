package com.example.jcomposetutorial.services

import com.example.jcomposetutorial.model.Todos
import com.example.jcomposetutorial.model.TodosItem
import com.example.jcomposetutorial.util.Constants.API_KEY
import retrofit2.http.*

interface TodosApi {
    @Headers("xc-token: $API_KEY")
    @GET("Todo")
    suspend fun getTodos(
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Todos

    @Headers("xc-token: $API_KEY")
    @POST("Todo")
    suspend fun addTodos(@Body body:TodosItem):Todos

}