package com.perficient.appointmentservice.controller;


import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.service.AppointmentListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ListAppointmentController {

    @Autowired
    private AppointmentListServiceImpl appointmentListService;

    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> retrieveAllAppointment() {
        try {
            List<Appointment> appointments = appointmentListService.retrieveAllAppointment();
            return ResponseEntity.status(HttpStatus.OK).body(appointments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}