package com.perficient.appointmentservice.controller;


import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.exception.AppointmentNotFoundException;
import com.perficient.appointmentservice.service.ListAllAppointmentsOfUserByIdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ListAllAppointmentsOfUserByIdController {

    @Autowired
    private ListAllAppointmentsOfUserByIdServiceImpl allAppointmentsOfUserByIdService;

    @GetMapping("/appointments/byUserId/{userId}")
    public ResponseEntity<List<Appointment>> retrieveAppointment(@PathVariable int userId) {
        try {
            List<Appointment> appointment = allAppointmentsOfUserByIdService.findByUserId(userId);
            return ResponseEntity.ok(appointment);
        } catch (AppointmentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
