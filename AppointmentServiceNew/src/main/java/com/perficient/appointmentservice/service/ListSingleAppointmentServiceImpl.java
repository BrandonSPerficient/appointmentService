package com.perficient.appointmentservice.service;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListSingleAppointmentServiceImpl {


    @Autowired
    private AppointmentRepository appointmentRepository;


    public Appointment findById(int aptId) {

        Appointment appointment = appointmentRepository.getById(aptId);
        return appointment;
    }
}
