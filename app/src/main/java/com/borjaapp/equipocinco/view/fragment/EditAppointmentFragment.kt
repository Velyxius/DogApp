package com.borjaapp.equipocinco.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.borjaapp.equipocinco.R
import com.borjaapp.equipocinco.databinding.FragmentEditAppointmentBinding
import com.borjaapp.equipocinco.model.Appointment
import com.borjaapp.equipocinco.viewmodel.AppointmentViewModel

class EditAppointmentFragment : Fragment() {
    private lateinit var binding: FragmentEditAppointmentBinding
    private val appointmentViewModel: AppointmentViewModel by viewModels()
    private lateinit var receivedAppointment: Appointment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditAppointmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataAppointment()
        controladores()
        observerViewModel()
    }

    private fun controladores(){
        binding.btnEdit.setOnClickListener {
            updateAppointment()
        }
    }

    private fun observerViewModel() {
        observerBreeds()
    }

    private fun dataAppointment(){
        val receivedBundle = arguments
        receivedAppointment = receivedBundle?.getSerializable("dataAppointment") as Appointment
        binding.petName.setText(receivedAppointment.petName)
        binding.ownerName.setText(receivedAppointment.ownerName)
        binding.phoneNumber.setText(receivedAppointment.ownerPhone.toString())
        binding.petBreed.setText(receivedAppointment.petBreed)
        //binding.ivImagenApi.setImageURI("${receivedAppointment.photoUrl}")
    }

    private fun updateAppointment(){

        val petName = binding.petName.text.toString()
        val breed = binding.petBreed.text.toString()
        val ownerName = binding.ownerName.text.toString()
        val phoneNumber = binding.phoneNumber.text.toString()
        val appointment = Appointment(
            receivedAppointment.id,
            petName = petName,
            petBreed = breed,
            ownerName = ownerName,
            ownerPhone = phoneNumber,
            symptoms = receivedAppointment.symptoms,
            photoUrl = receivedAppointment.photoUrl)
        appointmentViewModel.updateAppointment(appointment)
        findNavController().navigate(R.id.action_editAppointmentFragment_to_homeAppointmentFragment)

    }

    private fun observerBreeds() {
        appointmentViewModel.getBreeds()
        appointmentViewModel.breedList.observe(viewLifecycleOwner) { breeds ->
            val breedsList: MutableList<String> = mutableListOf()

            for ((breed, variants) in breeds) {
                if (variants.isEmpty()) {
                    breedsList.add(breed.replaceFirstChar { it.titlecase() })
                } else {
                    for (variant in variants) {
                        breedsList.add("${breed.replaceFirstChar { it.titlecase() }} ${variant.replaceFirstChar { it.titlecase() }}")
                    }
                }
            }

            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, breedsList)
            binding.petBreed.setAdapter(adapter)
        }
    }
}