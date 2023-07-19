package com.perficient.appointmentservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.service.UpdateAppointmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateAppointmentControllerTest {

    @InjectMocks
    private UpdateAppointmentController updateAppointmentController;

    @Mock
    private UpdateAppointmentServiceImpl updateAppointmentService;

    @Test
    void updateAppointment_ValidId_ReturnsUpdatedAppointment() throws Exception {
        int aptId = 1;

        Appointment existingAppointment = new Appointment();
        existingAppointment.setAptId(aptId);
        existingAppointment.setUserId(1);
        existingAppointment.setAptType("Checkup");
        existingAppointment.setAptName("Dentist");
        existingAppointment.setDescription("This is a bi-annually checkup visit");
        existingAppointment.setStartTime("12");
        existingAppointment.setEndTime("1");
        existingAppointment.setMetaData("adas");

        Appointment updatedAppointment = new Appointment();
        updatedAppointment.setAptId(aptId);
        updatedAppointment.setUserId(1);
        updatedAppointment.setAptType("New Checkup Type");
        updatedAppointment.setAptName("New Dentist");
        updatedAppointment.setDescription("Updated description");
        updatedAppointment.setStartTime("Updated start time");
        updatedAppointment.setEndTime("Updated end time");
        updatedAppointment.setMetaData("Updated meta data");

        when(updateAppointmentService.updateAppointment(aptId, updatedAppointment)).thenReturn(updatedAppointment);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(updateAppointmentController).build();

        ObjectMapper objectMapper = new ObjectMapper();
        String updatedAppointmentJson = objectMapper.writeValueAsString(updatedAppointment);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/appointments/{aptId}", aptId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAppointmentJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.aptId").value(aptId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.aptType").value("New Checkup Type"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.aptName").value("New Dentist"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Updated description"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startTime").value("Updated start time"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endTime").value("Updated end time"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.metaData").value("Updated meta data"));

        verify(updateAppointmentService).updateAppointment(aptId, updatedAppointment);
    }
}
