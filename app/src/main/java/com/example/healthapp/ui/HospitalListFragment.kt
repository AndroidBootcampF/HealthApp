package com.example.healthapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.healthapp.R
import com.example.healthapp.databinding.FragmentHospitalListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "Hospital List Fragment"

class HospitalListFragment : Fragment() {

    private var _binding: FragmentHospitalListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ListViewModel

    private lateinit var arrayAdapter: ArrayAdapter<*>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { _binding = FragmentHospitalListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.autoCompleteTextViewCity.setText("İstanbul")


        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getData()

        }

        viewModel.cities.observe(viewLifecycleOwner, Observer { cityList ->
            Log.e(TAG, "$cityList")

            arrayAdapter = ArrayAdapter(this.requireContext(), R.layout.dropdown_items, cityList)
            binding.autoCompleteTextViewCity.setAdapter (arrayAdapter)

        })
    }


}