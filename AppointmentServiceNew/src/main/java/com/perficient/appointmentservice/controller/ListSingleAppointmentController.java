package com.perficient.appointmentservice.controller;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.service.ListSingleAppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ListSingleAppointmentController {

    @Autowired
    private ListSingleAppointmentServiceImpl singleAppointmentServiceImpl;

    @GetMapping("/appointments/{aptId}")
    public ResponseEntity<?> retrieveAppointment(@PathVariable int aptId) {
        Appointment appointment = singleAppointmentServiceImpl.findById(aptId);
        try {
            return ResponseEntity.ok(appointment);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
