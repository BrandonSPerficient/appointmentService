package com.perficient.appointmentservice.service;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AppointmentListServiceImpl {

    @Autowired
    private AppointmentRepository appointmentRepository;


    public List<Appointment> retrieveAllAppointment() {
        return appointmentRepository.findAll();
    }



}
