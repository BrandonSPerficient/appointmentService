package com.perficient.appointmentservice.controller;

import com.perficient.appointmentservice.service.DeleteAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DeleteAppointment {
    @Autowired
    private DeleteAppointmentService deleteAppointmentService;

    @DeleteMapping("/appointments/{aptId}")
    @ResponseBody
    public void deleteAppointment(@PathVariable int aptId)
    {
        deleteAppointmentService.deleteAppointmentById(aptId);
    }

}
