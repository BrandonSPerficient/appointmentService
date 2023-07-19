package com.perficient.appointmentservice.service;


import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.exception.AppointmentNotFoundException;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListAllAppointmentsOfUserByIdServiceImpl {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Optional<List<Appointment>> findByUserId(Integer userId) {

        Optional<List<Appointment>> appointment = appointmentRepository.findByUserId(userId);
        if(appointment.isEmpty()) {
            throw new AppointmentNotFoundException("The Appointment doesn't exist");
        }
        return appointment;
    }

}
