package com.example.books.utils

import com.example.books.BooksResponse
import com.example.books.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface WebServices {
    @GET("api/v1/books")
    suspend fun getAllBooks(): BooksResponse

    @POST("api/v1/users/signup")
    suspend fun createUser(@Body user: User) : Response<User>
}