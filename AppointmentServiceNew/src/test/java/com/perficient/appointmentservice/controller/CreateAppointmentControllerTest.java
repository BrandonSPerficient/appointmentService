package com.perficient.appointmentservice.controller;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.service.CreateAppointmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CreateAppointmentControllerTest {

    @InjectMocks
    private CreateAppointmentController createAppointmentController;

    @Mock
    private CreateAppointmentServiceImpl createAppointmentService;

    @Test
    void createAppointment_ValidInput_ReturnsSuccess() throws Exception {
        Appointment appointment = new Appointment();
        appointment.setAptId(1);
        appointment.setAptName("Checkup");

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(createAppointmentController).build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/appointments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"aptId\": 1, \"aptName\": \"Checkup\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(createAppointmentService).save(appointment);
    }
}
