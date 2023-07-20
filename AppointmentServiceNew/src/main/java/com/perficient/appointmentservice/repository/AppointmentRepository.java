package com.perficient.appointmentservice.repository;

import com.perficient.appointmentservice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query("SELECT e FROM Appointment_service e WHERE e.userId = :userId")
    List<Appointment> findByUserId(@Param("userId") Integer userId);
}

