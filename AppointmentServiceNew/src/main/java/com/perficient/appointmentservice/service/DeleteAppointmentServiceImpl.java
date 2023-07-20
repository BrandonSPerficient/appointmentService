package com.perficient.appointmentservice.service;


import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.exception.AppointmentNotFoundException;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAppointmentServiceImpl {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public void deleteAppointmentById(Integer aptId) {
        Appointment appointment = appointmentRepository.findById(aptId)
                .orElseThrow(() -> new AppointmentNotFoundException("The Appointment doesn't exist"));
        appointmentRepository.delete(appointment);
    }
}
