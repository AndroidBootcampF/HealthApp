package com.example.healthapp.data.retrofit

import com.example.healthapp.data.Cities
import retrofit2.http.GET

interface RetrofitApi {


    @GET("tugceerdogan/JSONDataSet/master/city.json")
    suspend fun getCities(): List<Cities>
}