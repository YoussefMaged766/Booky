package com.example.books.ui.main


import androidx.lifecycle.ViewModel
import com.example.books.utils.ApiManager
import com.example.books.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainViewModel:ViewModel() {

    suspend fun getData() = flow {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(ApiManager.getwebbservices().getAllBooks()))
        } catch (e: Exception) {
            emit(Resource.error(null, e.message.toString()))
        }

    }.flowOn(Dispatchers.IO)


}