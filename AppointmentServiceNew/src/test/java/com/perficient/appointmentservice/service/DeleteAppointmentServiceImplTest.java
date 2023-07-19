package com.perficient.appointmentservice.service;


import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeleteAppointmentServiceImplTest {

    @InjectMocks
    private DeleteAppointmentServiceImpl deleteAppointmentService;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Test
    void deleteAppointmentTest()
    {

        Appointment appointment = new Appointment();

        when(appointmentRepository.findById(appointment.getAptId())).thenReturn(Optional.of(appointment));

        deleteAppointmentService.deleteAppointmentById(appointment.getAptId());

        verify(appointmentRepository).delete(appointment);


    }


}
