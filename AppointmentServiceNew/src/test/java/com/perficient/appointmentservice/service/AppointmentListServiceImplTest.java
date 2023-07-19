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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AppointmentListServiceImplTest {

    @InjectMocks
    private AppointmentListServiceImpl appointmentListService;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Test
    void retrieveAllAppointmentTest(){

        List<Appointment> appointments = new ArrayList<Appointment>();

        //setup any data

        //configure mock methods
        when(appointmentRepository.findAll()).thenReturn(appointments);

        //run methods under test
        appointmentListService.retrieveAllAppointment();

        //assertions and verify
        verify(appointmentRepository).findAll();
    }

}
