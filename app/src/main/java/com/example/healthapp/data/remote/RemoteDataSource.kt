package com.example.healthapp.data.remote

import com.example.healthapp.utils.BaseDataSource
import java.lang.annotation.Inherited
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: NetworkApiService):
    BaseDataSource() {

    suspend fun fetchListCharacters()=getResult { apiService.listCharacters() }
}