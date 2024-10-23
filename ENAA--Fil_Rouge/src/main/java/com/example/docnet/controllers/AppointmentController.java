package com.example.docnet.controllers;

import com.example.docnet.dto.AppointmentDto;
import com.example.docnet.models.Appointment;
import com.example.docnet.services.AppointmentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    // Constructor to inject the AppointmentService.
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    /**
     * Retrieves all appointments.
     *
     * @return A list of all appointments in the system.
     */
    @GetMapping("/getAll")
    public List<AppointmentDto> getAllAppointments() {
        return appointmentService.getAllAppointment();
    }

    /**
     * Retrieves a specific appointment by its ID.
     *
     * @param id The ID of the appointment to retrieve.
     * @return The appointment matching the provided ID.
     */
    @GetMapping("/get/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointment(id);
    }

    /**
     * Deletes an appointment by its ID (restricted to users with the 'DOCTOR' role).
     *
     * @param id The ID of the appointment to delete.
     */
    @PreAuthorize("hasRole('DOCTOR')")
    @DeleteMapping("/delete/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.delete(id);
    }

    /**
     * Updates an existing appointment by its ID (restricted to users with the 'DOCTOR' role).
     *
     * @param id The ID of the appointment to update.
     * @param appointment The updated appointment details.
     * @return The updated appointment.
     */
    @PreAuthorize("hasRole('DOCTOR')")
    @PutMapping("/update/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(appointment, id);
    }

    /**
     * Adds a new appointment for a specific patient and doctor (restricted to users with the 'PATIENT' role).
     *
     * @param appointment The appointment details to add.
     * @param patId The ID of the patient for the appointment.
     * @param docId The ID of the doctor for the appointment.
     * @return The created appointment.
     */
    @PreAuthorize("hasRole('PATIENT')")
    @PostMapping("/add/{patientId}&{docId}")
    public Appointment addAppointment(@RequestBody Appointment appointment, @PathVariable("patientId") Long patId, @PathVariable("docId") Long docId) {
        return appointmentService.addAppointment(appointment, patId, docId);
    }

    /**
     * Retrieves all appointments for a specific doctor (restricted to users with the 'DOCTOR' role).
     *
     * @param doctorId The ID of the doctor whose appointments are being retrieved.
     * @return A list of appointments for the specified doctor.
     */
    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("doctor/get/{doctorId}")
    public List<Appointment> getByDoctorId(@PathVariable Long doctorId) {
        return appointmentService.getAllByIdDoctor(doctorId);
    }

    /**
     * Retrieves all appointments for a specific patient (restricted to users with the 'PATIENT' role).
     *
     * @param patientId The ID of the patient whose appointments are being retrieved.
     * @return A list of appointments for the specified patient.
     */
    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("patient/get/{patientId}")
    public List<Appointment> getByPatientId(@PathVariable Long patientId) {
        return appointmentService.getAllByIdPatient(patientId);
    }

}
