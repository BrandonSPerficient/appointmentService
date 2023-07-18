package com.perficient.appointmentservice.controller;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.service.ListSingleAppointmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListSingleAppointmentControllerTest {

    @InjectMocks
    private ListSingleAppointmentController listSingleAppointmentController;

    @Mock
    private ListSingleAppointmentServiceImpl singleAppointmentService;

    @Test
    void retrieveAppointment_ValidId_ReturnsAppointment() throws Exception {
        int aptId = 1;
        Appointment appointment = new Appointment();
        appointment.setAptId(aptId);
        appointment.setAptName("Checkup");

        Optional<Appointment> optionalAppointment = Optional.of(appointment);

        when(singleAppointmentService.findById(aptId)).thenReturn(optionalAppointment);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(listSingleAppointmentController).build();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/appointments/{aptId}", aptId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.aptId").value(aptId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.aptName").value("Checkup"));
    }

    @Test
    void retrieveAppointment_InvalidId_ReturnsNotFound() throws Exception {
        int aptId = 1;

        when(singleAppointmentService.findById(aptId)).thenReturn(Optional.empty());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(listSingleAppointmentController).build();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/appointments/{aptId}", aptId))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
