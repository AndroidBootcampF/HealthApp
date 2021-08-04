package com.example.healthapp.data.remote

import com.example.healthapp.data.entity.Hospitals
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkApiService {
    @GET("hospitals/1")
    suspend fun listCharacters(): Response<Hospitals>


}