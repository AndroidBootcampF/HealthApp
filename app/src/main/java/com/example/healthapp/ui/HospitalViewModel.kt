package com.example.healthapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.healthapp.data.ApiRepository
import com.example.healthapp.data.entity.Hospitals
import com.example.healthapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HospitalViewModel @Inject constructor(
    var  savedStateHandle: SavedStateHandle,
    var apiRepository: ApiRepository
) : ViewModel(){

    fun fetchRickMortyList(): LiveData<Resource<Hospitals>> =
        apiRepository.getHospitalList()


}