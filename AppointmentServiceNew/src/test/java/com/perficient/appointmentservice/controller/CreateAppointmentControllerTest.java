package com.perficient.appointmentservice.controller;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.exception.AppointmentNotFoundException;
import com.perficient.appointmentservice.service.CreateAppointmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateAppointmentControllerTest {

    @InjectMocks
    private CreateAppointmentController createAppointmentController;

    @Mock
    private CreateAppointmentServiceImpl createAppointmentService;

    @Test
    void createAppointment_ValidInput_ReturnsSuccess() {
        // Arrange
        Appointment appointment = new Appointment();
        when(createAppointmentService.save(appointment)).thenReturn(appointment);

        // Act
        ResponseEntity<?> response = createAppointmentController.CreateAppointment(appointment);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Appointment was saved.", response.getBody());
    }

    @Test
    void createAppointment_InvalidInput_ReturnsConflict() {

        Appointment appointment = new Appointment();

        doThrow(new AppointmentNotFoundException("Appointment ID is not correct"))
                .when(createAppointmentService).save(appointment);


        ResponseEntity<?> response = createAppointmentController.CreateAppointment(appointment);


        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("Appointment ID is not correct", response.getBody());
    }
}
