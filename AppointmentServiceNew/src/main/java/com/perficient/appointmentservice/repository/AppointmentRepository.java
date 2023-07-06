package com.perficient.appointmentservice.repository;

import com.perficient.appointmentservice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


}
