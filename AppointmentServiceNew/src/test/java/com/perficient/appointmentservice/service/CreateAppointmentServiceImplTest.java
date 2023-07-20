package com.perficient.appointmentservice.service;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateAppointmentServiceImplTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private CreateAppointmentServiceImpl createAppointmentService;

    @Test
    void save_ValidAppointment_ReturnsSavedAppointment() {

        Appointment appointment = new Appointment();

        when(appointmentRepository.save(appointment)).thenReturn(appointment);

        Appointment savedAppointment = createAppointmentService.save(appointment);

        verify(appointmentRepository).save(appointment);
        assertEquals(appointment, savedAppointment);
    }
}
