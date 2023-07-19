package com.perficient.appointmentservice.service;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.exception.AppointmentNotFoundException;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ListAllAppointmentsOfUserByIdServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private ListAllAppointmentsOfUserByIdServiceImpl appointmentService;

    @Test
    public void findByUserId_ValidUserId_ReturnsAppointments() {

        Integer userId = 1;
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment());
        when(appointmentRepository.findByUserId(userId)).thenReturn(Optional.of(appointments));


        Optional<List<Appointment>> result = appointmentService.findByUserId(userId);

        assertTrue(result.isPresent());
        assertEquals(appointments, result.get());
        Mockito.verify(appointmentRepository).findByUserId(userId);
    }

    @Test
    public void findByUserId_InvalidUserId_ThrowsAppointmentNotFoundException() {
        // Arrange
        Integer userId = 2;
        when(appointmentRepository.findByUserId(userId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(AppointmentNotFoundException.class, () -> appointmentService.findByUserId(userId));
        Mockito.verify(appointmentRepository).findByUserId(userId);
    }
}
