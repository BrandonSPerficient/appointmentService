package com.perficient.appointmentservice.service;


import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.exception.AppointmentNotFoundException;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListSingleAppointmentServiceImplTest {

    @InjectMocks
    private ListSingleAppointmentServiceImpl listSingleAppointmentService;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Test
    void listSingleAppointmentTest() {

        Appointment appointment = new Appointment(1, 1, "Checkup", "Dentist", "This is a bi-annually checkup visit", "12", "1", "adas");

        when(appointmentRepository.findById(anyInt())).thenReturn(Optional.of(appointment));

        listSingleAppointmentService.findById(1);

        verify(appointmentRepository).findById(anyInt());

    }

    @Test
    void findById_InvalidId_ThrowsAppointmentNotFoundException() {

        Integer aptId = 2;
        when(appointmentRepository.findById(aptId)).thenReturn(Optional.empty());


        assertThrows(AppointmentNotFoundException.class, () -> listSingleAppointmentService.findById(aptId));
        verify(appointmentRepository).findById(aptId);
    }

}
