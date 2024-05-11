package com.borjaapp.equipocinco.view.viewholder

import android.os.Bundle
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.borjaapp.equipocinco.R
import com.borjaapp.equipocinco.databinding.ItemAppointmentBinding
import com.borjaapp.equipocinco.model.Appointment
import java.text.NumberFormat
import java.util.*

class AppointmentViewHolder (binding:ItemAppointmentBinding):RecyclerView.ViewHolder(binding.root){
    val bindingItem = binding

    fun setItemAppointment(appointment: Appointment){
        bindingItem.tvPetName.text = appointment.petName
        bindingItem.tvPhotoUrl.text = appointment.photoUrl
        bindingItem.tvSymptoms.text = appointment.symptoms

    }

}