package com.perficient.appointmentservice.controller;


import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.service.ListAppointmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListAppointmentController {
    @GetMapping
    public List<Appointment> retrieveAllAppointment(){
        return ListAppointmentService.findAll();
    }


}
