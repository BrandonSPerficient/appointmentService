package com.perficient.appointmentservice.controller;


import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.service.ListAllAppointmentsOfUserByIdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ListAllAppointmentsOfUserByIdController {

    @Autowired
    private ListAllAppointmentsOfUserByIdServiceImpl allAppointmentsOfUserByIdService;
    @GetMapping("/appointments/byUserId/{userId}")
    public Optional<List<Appointment>> retrieveAppointment(@PathVariable int userId)
    {
        Optional<List<Appointment>> appointment  = allAppointmentsOfUserByIdService.findByUserId(userId);
        return appointment;
    }
}
