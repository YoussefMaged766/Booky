package com.example.books.ui.signup

import androidx.lifecycle.ViewModel
import com.example.books.models.User
import com.example.books.utils.ApiManager
import com.example.books.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SignViewModel : ViewModel() {


    suspend fun postUser(user: User) = flow {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(ApiManager.getwebbservices().createUser(user)))
        } catch (e: Exception) {
                emit(Resource.error(null,e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}