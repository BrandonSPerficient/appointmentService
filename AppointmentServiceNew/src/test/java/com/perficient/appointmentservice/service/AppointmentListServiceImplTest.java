package com.perficient.appointmentservice.service;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AppointmentListServiceImplTest {

    @InjectMocks
    private AppointmentListServiceImpl appointmentListService;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Test
    void retrieveAllAppointment_ReturnsAllAppointments() {
        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(new Appointment(1, 1, "Checkup", "Dentist", "Bi-annual checkup", "12", "1", "metadata1"));
        appointmentList.add(new Appointment(2, 1, "Cleaning", "Dentist", "Regular cleaning", "10", "11", "metadata2"));

        when(appointmentRepository.findAll()).thenReturn(appointmentList);

        List<Appointment> result = appointmentListService.retrieveAllAppointment();

        assertEquals(appointmentList.size(), result.size());
        assertEquals(appointmentList.get(0).getAptName(), result.get(0).getAptName());
        assertEquals(appointmentList.get(1).getAptName(), result.get(1).getAptName());
    }
}
