package com.perficient.appointmentservice.service;

import com.perficient.appointmentservice.entity.Appointment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListAppointmentService {

    private static List<Appointment> appointments = new ArrayList<>();


    public static List<Appointment> findAll() {

        return appointments;
    }
}
