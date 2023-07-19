package com.perficient.appointmentservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.perficient.appointmentservice.controller.ListAllAppointmentsOfUserByIdController;
import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.service.ListAllAppointmentsOfUserByIdServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebMvcTest(ListAllAppointmentsOfUserByIdController.class)
public class ListAllAppointmentsOfUserByIdControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListAllAppointmentsOfUserByIdServiceImpl allAppointmentsOfUserByIdService;

    @Test
    void retrieveAppointment_ReturnsListOfAppointments() throws Exception {
        Appointment appointment1 = new Appointment(1, 1, "Checkup", "Dentist", "This is a bi-annually checkup visit", "12", "1", "adas");
        Appointment appointment2 = new Appointment(2, 2, "Dentist Visit", "Orthodontist", "Regular dental checkup", "13", "2", "xyz");

        List<Appointment> appointments = Arrays.asList(appointment1, appointment2);

        when(allAppointmentsOfUserByIdService.findByUserId(1)).thenReturn(Optional.of(appointments));

        mockMvc.perform(get("/api/v1/appointments/byUserId/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].aptId").value(1))
                .andExpect(jsonPath("$[0].userId").value(1))
                .andExpect(jsonPath("$[0].aptType").value("Checkup"))
                .andExpect(jsonPath("$[0].aptName").value("Dentist"))
                .andExpect(jsonPath("$[0].description").value("This is a bi-annually checkup visit"))
                .andExpect(jsonPath("$[0].startTime").value("12"))
                .andExpect(jsonPath("$[0].endTime").value("1"))
                .andExpect(jsonPath("$[0].metaData").value("adas"))
                .andExpect(jsonPath("$[1].aptId").value(2))
                .andExpect(jsonPath("$[1].userId").value(2))
                .andExpect(jsonPath("$[1].aptType").value("Dentist Visit"))
                .andExpect(jsonPath("$[1].aptName").value("Orthodontist"))
                .andExpect(jsonPath("$[1].description").value("Regular dental checkup"))
                .andExpect(jsonPath("$[1].startTime").value("13"))
                .andExpect(jsonPath("$[1].endTime").value("2"))
                .andExpect(jsonPath("$[1].metaData").value("xyz"));
    }
}
