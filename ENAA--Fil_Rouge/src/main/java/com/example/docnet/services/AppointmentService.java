package com.example.docnet.services;


import com.example.docnet.enums.AppointmentStatus;
import com.example.docnet.models.Appointment;
import com.example.docnet.models.HealthProfessional;
import com.example.docnet.models.Patient;
import com.example.docnet.repositories.AppointmentRepository;
import com.example.docnet.repositories.HealthProfessionalRepository;
import com.example.docnet.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointRepository;  // Dependency injection for the Appointment repository
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private HealthProfessionalRepository healthProfessionalRepository ;
    /**
     * Adds a new appointment to the database.
     * @param appointment The appointment to add.
     * @return The saved appointment.
     */
    public Appointment addAppointment(Appointment appointment , Long patId , Long docId) {
        Appointment appointment1=new Appointment();
        Patient patient = patientRepository.findById(patId).get();
        HealthProfessional doc = healthProfessionalRepository.findById(docId).get();
        appointment1.setDate(appointment.getDate());
        appointment1.setTime(appointment.getTime());
        appointment1.setPatient(patient);
        appointment1.setProfessional(doc);

        return appointRepository.save(appointment1);
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
        appointment1.setTime(appointment.getTime());
        appointment1.setDate(appointment.getDate());

        appointment1.setStatus(appointment.getStatus());
        appointment1.setAppointmentReason(appointment.getAppointmentReason());
        appointment1.setNote(appointment.getNote());

        return appointRepository.save(appointment1);  // Save the changes to the database
    }



    private final List<LocalTime> defaultHours = Arrays.asList(
            LocalTime.of(9, 0),
            LocalTime.of(9, 30),
            LocalTime.of(10, 0),
            LocalTime.of(10, 30),
            LocalTime.of(11, 0),
            LocalTime.of(11, 30),
            LocalTime.of(12, 0),
            LocalTime.of(12, 30),
            LocalTime.of(1, 0),
            LocalTime.of(2, 30),
            LocalTime.of(3, 0),
            LocalTime.of(3, 30),
            LocalTime.of(4, 0),
            LocalTime.of(4, 30)
    );

    public List<LocalTime> getAvailableTimes(LocalDate date) {
        List<Appointment> reservedAppointments = appointRepository.findByDateAndTimeIn(date, defaultHours);
        List<LocalTime> reservedTimes = reservedAppointments.stream()
                .map(Appointment::getTime)
                .collect(Collectors.toList());

        // Retourne les créneaux qui ne sont pas encore réservés
        return defaultHours.stream()
                .filter(time -> !reservedTimes.contains(time))
                .collect(Collectors.toList());
    }


    // Réserver un créneau
    public void reserveAppointment(LocalDate date, LocalTime time, Long patientId) {
        Appointment appointment = new Appointment();
        appointment.setDate(date);
        appointment.setTime(time);
        appointment.setStatus(AppointmentStatus.RESERVED);
        // Attribuez un patient, vous pouvez récupérer l'instance depuis le repo de patient
        appointRepository.save(appointment);
    }







}
