package com.perficient.appointmentservice.controller;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.service.AppointmentListServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListAppointmentControllerTest {

    @InjectMocks
    private ListAppointmentController listAppointmentController;

    @Mock
    private AppointmentListServiceImpl appointmentListService;

    @Test
    void retrieveAllAppointment_ReturnsListOfAppointments() throws Exception {
        Appointment appointment1 = new Appointment(1, 1, "Checkup", "Dentist", "This is a bi-annually checkup visit", "12", "1", "adas");
        Appointment appointment2 = new Appointment(2, 2, "Dentist Visit", "Orthodontist", "Regular dental checkup", "13", "2", "xyz");

        List<Appointment> appointments = new ArrayList<>();
        appointments.add(appointment1);
        appointments.add(appointment2);

        when(appointmentListService.retrieveAllAppointment()).thenReturn(appointments);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(listAppointmentController).build();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/appointments"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].aptId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].aptType").value("Checkup"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].aptName").value("Dentist"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("This is a bi-annually checkup visit"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].startTime").value("12"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].endTime").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].metaData").value("adas"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].aptId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].userId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].aptType").value("Dentist Visit"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].aptName").value("Orthodontist"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].description").value("Regular dental checkup"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].startTime").value("13"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].endTime").value("2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].metaData").value("xyz"));
    }
}
