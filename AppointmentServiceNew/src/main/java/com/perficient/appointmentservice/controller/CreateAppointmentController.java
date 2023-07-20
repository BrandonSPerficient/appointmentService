package com.perficient.appointmentservice.controller;


import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.exception.AppointmentNotFoundException;
import com.perficient.appointmentservice.service.CreateAppointmentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class CreateAppointmentController {

    private final CreateAppointmentServiceImpl createAppointmentService;

    public CreateAppointmentController(CreateAppointmentServiceImpl createAppointmentService) {
        this.createAppointmentService = createAppointmentService;
    }


    @PostMapping("/appointments")
    public ResponseEntity<?> CreateAppointment(@RequestBody Appointment appointment) {
        try {
            createAppointmentService.save(appointment);
            return ResponseEntity.status(HttpStatus.CREATED).body("Appointment was saved.");
        } catch (AppointmentNotFoundException e) {

            return ResponseEntity.status(HttpStatus.CONFLICT).body("Appointment ID is not correct");
        }

    }
}
