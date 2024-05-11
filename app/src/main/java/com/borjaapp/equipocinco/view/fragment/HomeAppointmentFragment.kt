package com.borjaapp.equipocinco.view.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.borjaapp.equipocinco.R
import com.borjaapp.equipocinco.databinding.FragmentHomeAppointmentBinding


class HomeAppointmentFragment : Fragment() {
    private lateinit var binding: FragmentHomeAppointmentBinding


//    private val appointmentViewModel: AppointmentViewModel by viewModels()
//    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeAppointmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //sharedPreferences = requireActivity().getSharedPreferences("shared", Context.MODE_PRIVATE)


    }

}