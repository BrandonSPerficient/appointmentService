package com.perficient.appointmentservice.controller;


import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import com.perficient.appointmentservice.service.AppointmentListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/")
public class ListAppointmentController {

    @Autowired
    private AppointmentListServiceImpl appointmentListService;


    @GetMapping("/appointments")
    public List<Appointment> retrieveAllAppointment() {
        return appointmentListService.retrieveAllAppointment();
    }
}