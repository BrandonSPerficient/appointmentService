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

    @InjectMocks
    private CreateAppointmentServiceImpl appointmentServiceImpl;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Test
    public void save_ValidAppointment_ReturnsSavedAppointmentWithIncrementedId() {

        Appointment appointment = new Appointment();
        appointment.setAptId(0);

        when(appointmentRepository.save(appointment)).thenReturn(appointment);


        Appointment savedAppointment = appointmentServiceImpl.save(appointment);

        verify(appointmentRepository).save(appointment);
        assertEquals(0, savedAppointment.getAptId());
    }
}
