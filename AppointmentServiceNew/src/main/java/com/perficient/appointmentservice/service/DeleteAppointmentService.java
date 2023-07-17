package com.perficient.appointmentservice.service;


import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.exception.AppointmentNotFoundException;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public void deleteAppointmentById(Integer aptId){
        Optional<Appointment> appointment = appointmentRepository.findById(aptId);
        if (appointment.isEmpty()) throw new AppointmentNotFoundException("The Appointment doesn't exist");
        appointmentRepository.delete(appointment.get());
    }
}
