package com.example.jcomposetutorial.di

import com.example.jcomposetutorial.services.TodosApi
import com.example.jcomposetutorial.services.UsersApi
import com.example.jcomposetutorial.repository.TodosRepository
import com.example.jcomposetutorial.repository.UsersRepository
import com.example.jcomposetutorial.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideUsersRepository(api: UsersApi)=UsersRepository(api)

    @Singleton
    @Provides
    fun provideTodosRepository(api: TodosApi)=TodosRepository(api)

    @Singleton
    @Provides
    fun provideUsersApi(): UsersApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(UsersApi::class.java)
    }

    @Singleton
    @Provides
    fun provideTodosApi(): TodosApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(TodosApi::class.java)
    }
}