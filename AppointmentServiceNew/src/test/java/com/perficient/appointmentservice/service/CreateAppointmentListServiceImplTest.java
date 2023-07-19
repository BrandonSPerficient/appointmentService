package com.perficient.appointmentservice.service;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateAppointmentListServiceImplTest {

    @InjectMocks
    private CreateAppointmentServiceImpl appointmentServiceImpl;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Test
    void createAppointmentTest()
    {
        Appointment appointment = new Appointment();

        when(appointmentRepository.save(appointment)).thenReturn(appointment);

        appointmentServiceImpl.save(appointment);

        verify(appointmentRepository).save(appointment);

    }



}
