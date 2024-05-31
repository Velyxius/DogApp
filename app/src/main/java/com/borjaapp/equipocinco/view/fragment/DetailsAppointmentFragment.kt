package com.borjaapp.equipocinco.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.borjaapp.equipocinco.R
import com.borjaapp.equipocinco.viewmodel.AppointmentViewModel
import com.borjaapp.equipocinco.databinding.FragmentDetailsAppointmentBinding
import com.borjaapp.equipocinco.model.Appointment
import com.bumptech.glide.Glide

class DetailsAppointmentFragment : Fragment() {

    private lateinit var binding: FragmentDetailsAppointmentBinding
    private val appointmentViewModel: AppointmentViewModel by viewModels()
    private lateinit var receivedAppointment: Appointment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsAppointmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    // Operaciones
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataAppointment()
        controladores()
        setupListeners()
    }

    private fun controladores() {
        binding.fbDelete.setOnClickListener {
            deleteAppointment()
        }

        binding.fbEdit.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("dataAppointment", receivedAppointment)
            findNavController().navigate(R.id.action_detailsAppointmentFragment_to_editAppointmentFragment, bundle)
        }
    }

    private fun setupListeners() {
        binding.toolbarDetails.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun dataAppointment() {
        val receivedBundle = arguments
        receivedAppointment = receivedBundle?.getSerializable("key") as Appointment
        binding.tvTurn.text = "#${receivedAppointment.id}"
        binding.toolbarDetails.tvTitle.text = "${receivedAppointment.petName}"
        binding.tvBreed.text = "${receivedAppointment.petBreed}"
        binding.tvOwner.text = "Propietario: ${receivedAppointment.ownerName}"
        binding.tvPhone.text = "Teléfono: ${receivedAppointment.ownerPhone}"
        binding.tvSymptom.text = "${receivedAppointment.symptoms}"
        Glide.with(requireContext())
            .load(receivedAppointment.photoUri.toString())
            .into(binding.ivPet)
    }

    private fun deleteAppointment() {
        appointmentViewModel.deleteAppointment(receivedAppointment)
        appointmentViewModel.getListAppointment()
        findNavController().popBackStack()
    }
}