package com.example.ENAA__Fil_Rouge.services;


import com.example.ENAA__Fil_Rouge.models.Appointment;
import com.example.ENAA__Fil_Rouge.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointRepository;  // Dependency injection for the Appointment repository

    /**
     * Adds a new appointment to the database.
     * @param appointment The appointment to add.
     * @return The saved appointment.
     */
    public Appointment addAppointment(Appointment appointment) {
        return appointRepository.save(appointment);
    }

    /**
     * Retrieves all appointments from the database.
     * @return A list of all appointments.
     */
    public List<Appointment> getAllAppointment() {
        return appointRepository.findAll();
    }

    /**
     * Deletes an appointment from the database using its ID.
     * @param idAppoint The ID of the appointment to delete.
     */
    public void delete(Long idAppoint) {
        appointRepository.deleteById(idAppoint);
    }

    /**
     * Retrieves a specific appointment using its ID.
     * @param idAppoint The ID of the appointment to retrieve.
     * @return The appointment corresponding to the provided ID.
     */
    public Appointment getAppointment(Long idAppoint) {
        return appointRepository.findById(idAppoint).orElse(null);
    }

    /**
     * Updates an existing appointment with new information.
     * @param appointment The appointment containing the new information.
     * @param id The ID of the appointment to update.
     * @return The updated appointment.
     */
    public Appointment updateAppointment(Appointment appointment, Long id) {
        Appointment appointment1 = getAppointment(id);  // Retrieves the appointment by ID

        // Update the fields of the existing appointment
        appointment1.setDateTime(appointment.getDateTime()); // Utilisez setDateTime() si vous avez fusionné date et time
        appointment1.setStatus(appointment.getStatus());
        appointment1.setAppointmentReason(appointment.getAppointmentReason());
        appointment1.setNote(appointment.getNote());

        return appointRepository.save(appointment1);  // Save the changes to the database
    }


}
