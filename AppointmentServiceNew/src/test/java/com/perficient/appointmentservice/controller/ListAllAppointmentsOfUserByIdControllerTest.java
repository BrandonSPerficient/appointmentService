package com.perficient.appointmentservice.controller;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.exception.AppointmentNotFoundException;
import com.perficient.appointmentservice.service.ListAllAppointmentsOfUserByIdServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class ListAllAppointmentsOfUserByIdControllerTest {

    @InjectMocks
    private ListAllAppointmentsOfUserByIdController listAllAppointmentsController;

    @Mock
    private ListAllAppointmentsOfUserByIdServiceImpl allAppointmentsOfUserByIdService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(listAllAppointmentsController).build();
    }

    @Test
    public void retrieveAppointment_AppointmentsFound_ReturnsAppointments() throws Exception {
        int userId = 1;
        Appointment appointment1 = new Appointment(1, userId, "Checkup", "Dentist", "This is a checkup visit", "12", "1", "adas");
        Appointment appointment2 = new Appointment(2, userId, "Dentist Visit", "Orthodontist", "Regular dental checkup", "13", "2", "xyz");

        List<Appointment> appointments = Arrays.asList(appointment1, appointment2);

        when(allAppointmentsOfUserByIdService.findByUserId(userId)).thenReturn(appointments);

        mockMvc.perform(get("/api/v1/appointments/byUserId/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].aptId").value(1))
                .andExpect(jsonPath("$[0].userId").value(userId))
                .andExpect(jsonPath("$[0].aptType").value("Checkup"))
                .andExpect(jsonPath("$[0].aptName").value("Dentist"))
                .andExpect(jsonPath("$[0].description").value("This is a checkup visit"))
                .andExpect(jsonPath("$[0].startTime").value("12"))
                .andExpect(jsonPath("$[0].endTime").value("1"))
                .andExpect(jsonPath("$[0].metaData").value("adas"))
                .andExpect(jsonPath("$[1].aptId").value(2))
                .andExpect(jsonPath("$[1].userId").value(userId))
                .andExpect(jsonPath("$[1].aptType").value("Dentist Visit"))
                .andExpect(jsonPath("$[1].aptName").value("Orthodontist"))
                .andExpect(jsonPath("$[1].description").value("Regular dental checkup"))
                .andExpect(jsonPath("$[1].startTime").value("13"))
                .andExpect(jsonPath("$[1].endTime").value("2"))
                .andExpect(jsonPath("$[1].metaData").value("xyz"));
    }

    @Test
    public void retrieveAppointment_NoAppointmentsFound_ReturnsNotFound() throws Exception {
        int userId = 2;

        when(allAppointmentsOfUserByIdService.findByUserId(userId)).thenThrow(new AppointmentNotFoundException("The Appointment doesn't exist"));

        mockMvc.perform(get("/api/v1/appointments/byUserId/{userId}", userId))
                .andExpect(status().isNotFound());
    }
}
