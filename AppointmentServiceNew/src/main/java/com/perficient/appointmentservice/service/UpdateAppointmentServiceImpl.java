package com.perficient.appointmentservice.service;

import com.perficient.appointmentservice.entity.Appointment;
import com.perficient.appointmentservice.exception.AppointmentNotFoundException;
import com.perficient.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateAppointmentServiceImpl {

    @Autowired
    private AppointmentRepository appointmentRepository;

    private void update(Appointment appointment, Appointment currentAppointment) {
        currentAppointment.setAptName(appointment.getAptName());
        currentAppointment.setAptType(appointment.getAptType());
        currentAppointment.setDescription(appointment.getDescription());
        currentAppointment.setStartTime(appointment.getStartTime());
        currentAppointment.setEndTime(appointment.getEndTime());
        currentAppointment.setMetaData(appointment.getMetaData());
    }

    public Appointment updateAppointment(int aptId, Appointment appointment) {
        Optional<Appointment> currentAppointment = appointmentRepository.findById(aptId);
        if (currentAppointment.isEmpty())
            throw new AppointmentNotFoundException("The Appointment doesn't exist");
        update(appointment, currentAppointment.get());
        appointmentRepository.save(currentAppointment.get());
        return currentAppointment.get(); // Return the updated appointment
    }
}
