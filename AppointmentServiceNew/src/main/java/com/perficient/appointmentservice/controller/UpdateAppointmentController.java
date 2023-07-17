package com.perficient.appointmentservice.controller;


import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.service.UpdateAppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UpdateAppointmentController {

    @Autowired
    private UpdateAppointmentService appointmentService;

    @PutMapping("/appointments/{aptId}")
    public Appointment updateAppointment(@PathVariable int aptId, @Valid @RequestBody Appointment appointment)
    {
        Appointment updatedAppointment = appointmentService.updateAppointment(aptId, appointment);
        return updatedAppointment;
    }
}
