package com.example.healthapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.healthapp.R
import com.example.healthapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HospitalListFragment : Fragment() {
    private val viewModel:HospitalViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hospital_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchRickMortyList().observe(viewLifecycleOwner,{
            when(it.status){
                Resource.Status.LOADING->{
                    Log.v("HospitalList","Yükleniyor")
                }
                Resource.Status.SUCCESS->{
                    Log.v("HospitalList","${it.data}")


                }
                Resource.Status.ERROR->{
                    Log.v("HospitalList","Hata Verdi")
                }
            }
        })
    }


}