package com.perficient.appointmentservice.service;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListSingleAppointmentServiceImpl {


    @Autowired
    private AppointmentRepository appointmentRepository;


    public Optional<Appointment> findById(Integer aptId) {

        Optional<Appointment> appointment = appointmentRepository.findById(aptId);
        return appointment;
    }

}
