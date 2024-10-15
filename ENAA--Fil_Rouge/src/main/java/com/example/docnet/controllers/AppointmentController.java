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

 

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @GetMapping("/getAll")
    public List<AppointmentDto> getAllAppointments() {
        return appointmentService.getAllAppointment();
    }

    @GetMapping("/get/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointment(id);
    }

    @PreAuthorize("hasRole('DOCTOR')")
    @DeleteMapping("/delete/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.delete(id);
    }

    @PreAuthorize("hasRole('DOCTOR')")
    @PutMapping("/update/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(appointment, id);
    }

    @PreAuthorize("hasRole('PATIENT')")
    @PostMapping("/add/{patientId}&{docId}")
    public Appointment addAppointment(@RequestBody Appointment appointment , @PathVariable("patientId") Long patId , @PathVariable("docId") Long docId) {
        return appointmentService.addAppointment(appointment,patId,docId);
    }

    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("doctor/get/{doctorId}")
    public List <Appointment> getByDoctorId(@PathVariable Long doctorId) {
        return appointmentService.getAllByIdDoctor(doctorId);
    }

    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("patient/get/{patientId}")
    public List <Appointment> getByPatientId(@PathVariable Long patientId) {
        return appointmentService.getAllByIdPatient(patientId);
    }

}
