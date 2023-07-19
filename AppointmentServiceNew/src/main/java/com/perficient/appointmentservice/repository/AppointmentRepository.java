package com.perficient.appointmentservice.repository;

import com.perficient.appointmentservice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    Optional<List<Appointment>> findByUserId(Integer userId);
}

