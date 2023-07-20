package com.perficient.appointmentservice.service;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.exception.AppointmentNotFoundException;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentListServiceImpl {

    @Autowired
    private AppointmentRepository appointmentRepository;


    public List<Appointment> retrieveAllAppointment() {

        List<Appointment> appointments = appointmentRepository.findAll();
        if (appointments.isEmpty()) {
            throw new AppointmentNotFoundException("No appointments found.");
        }
        return appointmentRepository.findAll();
    }
}
