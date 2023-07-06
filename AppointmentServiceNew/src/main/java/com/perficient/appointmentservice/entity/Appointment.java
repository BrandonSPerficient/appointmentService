package com.perficient.appointmentservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Future;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Appointment_entity")
public class Appointment {

    @Id
    @GeneratedValue
    private int aptId;
    @NotBlank
    private String aptType;
    @NotBlank
    private String aptName;
    private String description;
    //@Future(message = "Start time has to be in the future.")
    private LocalDateTime startTime;
    //@Future(message = "End Timme  has to be in the future:")
    private LocalDateTime endTime;
    private String metaData;

}
