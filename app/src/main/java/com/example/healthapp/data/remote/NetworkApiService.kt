package com.example.healthapp.data.remote

import com.example.healthapp.data.entity.Hospitals
import com.example.healthapp.data.entity.HospitalsItem
import retrofit2.Response
import retrofit2.http.GET

interface NetworkApiService {
    @GET("hospitals")
    suspend fun listCharacters(): Response<Hospitals>


}