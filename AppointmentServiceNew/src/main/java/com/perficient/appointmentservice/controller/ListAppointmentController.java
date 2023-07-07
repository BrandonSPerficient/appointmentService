package com.perficient.appointmentservice.controller;


import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/appointments")
public class ListAppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public List<Appointment> retrieveAllAppointment() {
        return appointmentRepository.findAll();
    }

    @PostMapping
    public void upload(@RequestBody Appointment appointment) {
        appointmentRepository.save(appointment);
    }










}
