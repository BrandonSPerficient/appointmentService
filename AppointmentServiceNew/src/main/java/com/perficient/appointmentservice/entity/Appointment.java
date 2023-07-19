package com.perficient.appointmentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Appointment_service")
public class Appointment {
    @Id
    @GeneratedValue
    private Integer aptId;
    private Integer userId;
    @NotBlank
    private String aptType;
    @NotBlank
    private String aptName;
    private String description;
    private String startTime;
    private String endTime;
    private String metaData;

}


