package com.perficient.appointmentservice.service;

import com.perficient.appointmentservice.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AppointmentListServiceImpl {

    AppointmentListServiceImpl appointmentListServiceImpl;

    @Autowired
    public ListAppointmentController (AppointmentListServiceImpl appointmentListServiceImpl)
    {
        this.appointmentListServiceImpl = appointmentListServiceImpl;
    }

    @GetMapping
    public List<Appointment> retrieveAllAppointment() {
        return appointmentListServiceImpl.findAll();
    }



}
