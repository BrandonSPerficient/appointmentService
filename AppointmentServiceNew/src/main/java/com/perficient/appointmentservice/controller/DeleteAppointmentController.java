package com.perficient.appointmentservice.controller;

import com.perficient.appointmentservice.service.DeleteAppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DeleteAppointmentController {

    @Autowired
    private DeleteAppointmentServiceImpl deleteAppointmentServiceImpl;

    @DeleteMapping("/appointments/{aptId}")
    @ResponseBody
    public void deleteAppointment(@PathVariable int aptId)
    {
        deleteAppointmentServiceImpl.deleteAppointmentById(aptId);
    }
}
