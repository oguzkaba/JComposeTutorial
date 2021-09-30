package com.example.jcomposetutorial.repository

import com.example.jcomposetutorial.services.UsersApi
import com.example.jcomposetutorial.model.Users
import com.example.jcomposetutorial.util.Constants.API_KEY
import com.example.jcomposetutorial.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class UsersRepository @Inject constructor(
    private val api: UsersApi
) {
    suspend fun getUsersList(): Resource<Users> {
        val response=try {
            api.getUsers()
        }catch (e:Exception){
            return Resource.Error("Beklenmeyen bir hata oluştu.")
        }
        return Resource.Success(response)
    }
}