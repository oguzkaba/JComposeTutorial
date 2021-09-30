package com.example.jcomposetutorial.repository

import com.example.jcomposetutorial.services.TodosApi
import com.example.jcomposetutorial.model.Todos
import com.example.jcomposetutorial.util.Constants.API_KEY
import com.example.jcomposetutorial.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class TodosRepository @Inject constructor(
    private val api: TodosApi
) {
    suspend fun getTodosList(): Resource<Todos> {
        val response=try {
            api.getTodos()
        }catch (e:Exception){
            return Resource.Error("Beklenmeyen bir hata oluştu. $e")
        }
        return Resource.Success(response)
    }
}