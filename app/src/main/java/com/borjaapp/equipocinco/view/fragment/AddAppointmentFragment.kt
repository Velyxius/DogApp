package com.borjaapp.equipocinco.view.fragment

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.borjaapp.equipocinco.databinding.FragmentAddAppointmentBinding
import com.borjaapp.equipocinco.model.Appointment
import com.borjaapp.equipocinco.viewmodel.AppointmentViewModel



class AddIAppointmentFragment : Fragment() {

    private lateinit var binding: FragmentAddAppointmentBinding
    private val appointmentViewModel: AppointmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddAppointmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controladores()
    }

    private fun controladores() {
        binding.toolbar.toolbarTitle.setText("Agregar cita")
        binding.toolbar.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
        validarDatos()
        binding.btnSaveAppointment.setOnClickListener {

        }
    }


    private fun cleanFields() {
        binding.etId.setText("")
        binding.etName.setText("")
        binding.etPrice.setText("")
        binding.etQuantity.setText("")
    }

    private fun validarDatos() {
        val listEditText = listOf(binding.etId, binding.etName, binding.etPrice, binding.etQuantity)

        val btn = binding.btnSaveAppointment
        btn.isEnabled = false // Initially, disable the button
        btn.setTextColor(Color.GRAY)


        for (editText in listEditText) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    // Check if all EditText fields have non-empty text
                    val isListFull = listEditText.all {
                        it.text?.isNotEmpty() == true
                    }
                    // Change the color if all the fields are filled or not
                    val color = if(isListFull) Color.WHITE else Color.GRAY

                    btn.setTextColor(color)
                    btn.isEnabled = isListFull
                }
            })
        }

    }
}