package com.example.docnet.services;


import com.example.docnet.dto.AppointmentDto;
import com.example.docnet.enums.AppointmentStatus;
import com.example.docnet.exceptions.AppointmentNotFoundException;
import com.example.docnet.exceptions.HealthProfessionalNotFoundException;
import com.example.docnet.exceptions.PatientNotFoundException;
import com.example.docnet.mapper.AppointmentMapper;
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

    private final AppointmentRepository appointRepository;
    private final PatientRepository patientRepository;
    private final HealthProfessionalRepository healthProfessionalRepository ;

    private final AppointmentMapper appointmentMapper;

    public AppointmentService(AppointmentRepository appointRepository, PatientRepository patientRepository, HealthProfessionalRepository healthProfessionalRepository, AppointmentMapper appointmentMapper) {
        this.appointRepository = appointRepository;
        this.patientRepository = patientRepository;
        this.healthProfessionalRepository = healthProfessionalRepository;
        this.appointmentMapper = appointmentMapper;
    }

    /**
     * Adds a new appointment to the database.
     * @param appointment The appointment to add.
     * @return The saved appointment.
     */
    public Appointment addAppointment(Appointment appointment , Long patId , Long docId) {
        Appointment appointment1=new Appointment();

        Patient patient = patientRepository.findById(patId)
                .orElseThrow(() -> new PatientNotFoundException(patId));

        HealthProfessional doc = healthProfessionalRepository.findById(docId)
                .orElseThrow(() -> new HealthProfessionalNotFoundException(docId));

        appointment1.setDate(appointment.getDate());
        appointment1.setTime(appointment.getTime());
        appointment1.setNote(appointment.getNote());
        appointment1.setAppointmentReason(appointment.getAppointmentReason());
        appointment1.setStatus(appointment.getStatus());
        appointment1.setPatient(patient);
        appointment1.setProfessional(doc);

        return appointRepository.save(appointment1);
    }


    /**
     * Retrieves all appointments from the database.
     * @return A list of all appointments.
     */
    public List<AppointmentDto> getAllAppointment() {
        return appointmentMapper.toDtos(appointRepository.findAll());
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
        return appointRepository.findById(idAppoint)
                .orElseThrow(() -> new AppointmentNotFoundException(idAppoint));
    }

    /**
     * Updates an existing appointment with new information.
     * @param appointment The appointment containing the new information.
     * @param id The ID of the appointment to update.
     * @return The updated appointment.
     */
    public Appointment updateAppointment(Appointment appointment, Long id) {
        Appointment appointment1 = getAppointment(id);

        appointment1.setTime(appointment.getTime());
        appointment1.setDate(appointment.getDate());

        appointment1.setStatus(appointment.getStatus());
        appointment1.setAppointmentReason(appointment.getAppointmentReason());
        appointment1.setNote(appointment.getNote());

        return appointRepository.save(appointment1);
    }

    public List<Appointment> getAllByIdPatient(Long patientId) {
        return appointRepository.findByPatient_Id(patientId);
    }
    public List<Appointment> getAllByIdDoctor(Long doctorId) {
        return appointRepository.findByProfessional_Id(doctorId);
    }







}
