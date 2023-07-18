package com.perficient.appointmentservice.controller;

import com.perficient.appointmentservice.service.DeleteAppointmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DeleteAppointmentControllerTest {

    @InjectMocks
    private DeleteAppointmentController deleteAppointmentController;

    @Mock
    private DeleteAppointmentServiceImpl deleteAppointmentService;

    @Test
    void deleteAppointment_ValidId_ReturnsSuccess() throws Exception {
        int aptId = 1;

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(deleteAppointmentController).build();

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/v1/appointments/{aptId}", aptId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(deleteAppointmentService).deleteAppointmentById(aptId);
    }
}
