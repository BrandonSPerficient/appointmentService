package com.perficient.appointmentservice.controller;

import com.perficient.appointmentservice.exception.AppointmentNotFoundException;
import com.perficient.appointmentservice.service.DeleteAppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DeleteAppointmentController {

    @Autowired
    private DeleteAppointmentServiceImpl deleteAppointmentServiceImpl;

    @DeleteMapping("/appointments/{aptId}")
    @ResponseBody
    public ResponseEntity<String> deleteAppointment(@PathVariable int aptId) {

        try {
            deleteAppointmentServiceImpl.deleteAppointmentById(aptId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Appointment with Id " + aptId + " deleted successfully.");
        } catch (AppointmentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }
}
