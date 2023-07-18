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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateAppointmentServiceImplTest {

    @InjectMocks
    private UpdateAppointmentServiceImpl updateAppointmentService;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Test
    void updateAppointment_ValidId_ReturnsUpdatedAppointment() {
        int aptId = 1;
        Appointment existingAppointment = new Appointment();
        existingAppointment.setAptId(aptId);
        existingAppointment.setAptName("Checkup");

        Appointment updatedAppointment = new Appointment();
        updatedAppointment.setAptId(aptId);
        updatedAppointment.setAptName("New Checkup");

        when(appointmentRepository.findById(aptId)).thenReturn(Optional.of(existingAppointment));
        when(appointmentRepository.save(existingAppointment)).thenReturn(existingAppointment);

        Appointment result = updateAppointmentService.updateAppointment(aptId, updatedAppointment);

        assertEquals(updatedAppointment.getAptName(), result.getAptName());
        verify(appointmentRepository, times(1)).findById(aptId);
        verify(appointmentRepository, times(1)).save(existingAppointment);
    }

    @Test
    void updateAppointment_InvalidId_ThrowsAppointmentNotFoundException() {
        int aptId = 1;
        Appointment updatedAppointment = new Appointment();
        updatedAppointment.setAptId(aptId);
        updatedAppointment.setAptName("New Checkup");

        when(appointmentRepository.findById(aptId)).thenReturn(Optional.empty());

        assertThrows(AppointmentNotFoundException.class, () -> {
            updateAppointmentService.updateAppointment(aptId, updatedAppointment);
        });

        verify(appointmentRepository, times(1)).findById(aptId);
        verify(appointmentRepository, never()).save(any());
    }
}
