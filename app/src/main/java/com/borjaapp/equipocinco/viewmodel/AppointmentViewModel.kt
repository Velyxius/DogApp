package com.borjaapp.equipocinco.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.borjaapp.equipocinco.model.Appointment
import com.borjaapp.equipocinco.repository.AppointmentRepository
import kotlinx.coroutines.launch

//import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch


class AppointmentViewModel (
    private val appointmentAppointment: AppointmentRepository
) : ViewModel() {


    private val _listAppointment = MutableLiveData<MutableList<Appointment>>()
    val listAppointment: LiveData<MutableList<Appointment>> get() = _listAppointment

    private val _progresState = MutableLiveData(false)
    val progresState: LiveData<Boolean> = _progresState


}