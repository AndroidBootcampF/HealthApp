package com.example.healthapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthapp.data.Cities
import com.example.healthapp.data.retrofit.RetrofitInstance
import kotlinx.coroutines.launch

private const val TAG = "City List View Model"
class ListViewModel : ViewModel() {

    private var _cities = MutableLiveData<List<Cities>>()
    val cities: LiveData<List<Cities>>
    get() = _cities


    fun getData() {
        viewModelScope.launch {
            try {
                _cities.value = RetrofitInstance.retrofitInstance.getCities()
            } catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }
        }
    }
}