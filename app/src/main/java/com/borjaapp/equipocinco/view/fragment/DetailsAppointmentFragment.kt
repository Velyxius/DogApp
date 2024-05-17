package com.borjaapp.equipocinco.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.borjaapp.equipocinco.R
import com.borjaapp.equipocinco.databinding.FragmentDetailsAppointmentBinding

class DetailsAppointmentFragment : Fragment() {

    private lateinit var binding: FragmentDetailsAppointmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsAppointmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    // OPeraciones
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controladores()
    }

    private fun controladores() {
        TODO("Not yet implemented")
    }



}