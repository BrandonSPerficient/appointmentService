package com.perficient.appointmentservice.service;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAppointmentServiceImpl {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
