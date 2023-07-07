package com.perficient.appointmentservice.controller;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import com.perficient.appointmentservice.service.ListSingleAppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ListSingleAppointmentController {

    @Autowired
    private ListSingleAppointmentServiceImpl singleAppointmentServiceImpl;


    @GetMapping("/appointments/{aptId}")
    @ResponseBody
    public Appointment retrieveAppointment(@PathVariable int aptId)
    {
        return singleAppointmentServiceImpl.findById(aptId);
    }


}
