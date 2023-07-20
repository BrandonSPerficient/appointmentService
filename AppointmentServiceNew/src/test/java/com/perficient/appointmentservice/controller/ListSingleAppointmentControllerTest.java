package com.perficient.appointmentservice.controller;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.service.ListSingleAppointmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListSingleAppointmentControllerTest {

    @Mock
    private ListSingleAppointmentServiceImpl singleAppointmentService;

    @InjectMocks
    private ListSingleAppointmentController listSingleAppointmentController;

    @Test
    void retrieveAppointment_ValidId_ReturnsAppointment() {
        int aptId = 1;
        Appointment appointment = new Appointment();
        appointment.setAptId(aptId);
        appointment.setAptName("Checkup");

        when(singleAppointmentService.findById(aptId)).thenReturn(appointment);

        ResponseEntity<?> response = listSingleAppointmentController.retrieveAppointment(aptId);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(appointment, response.getBody());
    }
}
