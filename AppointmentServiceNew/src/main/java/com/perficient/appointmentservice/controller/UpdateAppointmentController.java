package com.perficient.appointmentservice.controller;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.service.UpdateAppointmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class UpdateAppointmentController {

    @Autowired
    private UpdateAppointmentServiceImpl appointmentService;

    @PutMapping("/appointments/{aptId}")
    public ResponseEntity<Appointment> updateAppointment(
            @PathVariable int aptId,
            @Valid @RequestBody Appointment appointment
    ) {
        try {
            Appointment updatedAppointment = appointmentService.updateAppointment(aptId, appointment);
            return ResponseEntity.ok(updatedAppointment);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
