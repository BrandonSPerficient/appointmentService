package com.perficient.appointmentservice.controller;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.service.ListSingleAppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ListSingleAppointmentController {

    @Autowired
    private ListSingleAppointmentServiceImpl singleAppointmentServiceImpl;


    @GetMapping("/appointments/{aptId}")
    public Optional<Appointment> retrieveAppointment(@PathVariable int aptId)
    {
      Optional<Appointment> appointment  = singleAppointmentServiceImpl.findById(aptId);
      return appointment;
    }


}
