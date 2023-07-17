package com.perficient.appointmentservice.controller;


import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.service.CreateAppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CreateAppointmentController {

    @Autowired
    private CreateAppointmentServiceImpl createAppointmentService;

    @PostMapping("/appointments")
    public void CreateAppointmentService(@RequestBody Appointment appointment)
    {
        createAppointmentService.save(appointment);
    }
}
