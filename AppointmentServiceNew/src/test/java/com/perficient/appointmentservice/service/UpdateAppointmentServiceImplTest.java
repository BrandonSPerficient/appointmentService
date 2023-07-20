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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        int userId = 1;
        Appointment existingAppointment = new Appointment();
        existingAppointment.setAptId(aptId);
        existingAppointment.setUserId(1);
        existingAppointment.setAptName("Checkup");
        existingAppointment.setAptType("Dentist");
        existingAppointment.setDescription("This is a bi-annually checkup visit");
        existingAppointment.setStartTime("12:00");
        existingAppointment.setEndTime("1:00");
        existingAppointment.setMetaData("asds");

        Appointment updatedAppointment = new Appointment();
        updatedAppointment.setAptId(aptId);
        updatedAppointment.setUserId(1);
        updatedAppointment.setAptName("New Checkup");
        updatedAppointment.setAptType("Dermatology");
        updatedAppointment.setDescription("This is a bi-annually checkup visit");
        updatedAppointment.setStartTime("10:00");
        updatedAppointment.setEndTime("11:00");
        updatedAppointment.setMetaData("asds");

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
