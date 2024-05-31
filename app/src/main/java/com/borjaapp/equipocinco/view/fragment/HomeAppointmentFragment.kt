package com.borjaapp.equipocinco.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.borjaapp.equipocinco.R
import com.borjaapp.equipocinco.databinding.FragmentHomeAppointmentBinding
import com.borjaapp.equipocinco.databinding.ItemAppointmentBinding
import com.borjaapp.equipocinco.view.adapter.AppointmentAdapter
import com.borjaapp.equipocinco.viewmodel.AppointmentViewModel
class HomeAppointmentFragment : Fragment() {

    private lateinit var binding: FragmentHomeAppointmentBinding
    private lateinit var bindingItem: ItemAppointmentBinding
    private val appointmentViewModel: AppointmentViewModel by viewModels()


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
        controladores()
        observerViewModel()
        recycler()
    }

    private fun observerViewModel() {
        observerListAppointment()
    }


    private fun observerListAppointment() {
        appointmentViewModel.getListAppointment()

        appointmentViewModel.listAppointment.observe(viewLifecycleOwner) {listAppointment ->
            val recycler = binding.recyclerview
            val layoutManager = LinearLayoutManager(context)
            recycler.layoutManager = layoutManager
            val adapter = AppointmentAdapter(listAppointment, findNavController())
            recycler.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }

    private fun controladores() {
        binding.fbagregar.setOnClickListener {
            findNavController().navigate(R.id.action_homeAppointmentFragment_to_addAppointmentFragment)
        }
    }

    fun recycler(){
        val recycler = binding.recyclerview
        recycler.layoutManager = LinearLayoutManager(context)
    }

}