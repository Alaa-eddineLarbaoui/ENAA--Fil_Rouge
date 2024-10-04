package com.example.docnet.controllers;

import com.example.docnet.models.Appointment;
import com.example.docnet.services.AppointmentService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

 

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @GetMapping("/getAll")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointment();
    }

    @GetMapping("/get/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointment(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.delete(id);
    }

    @PutMapping("/update/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(appointment, id);
    }


    @PostMapping("/add/{patientId}&{docId}")
    public Appointment addAppointment(@RequestBody Appointment appointment , @PathVariable("patientId") Long patId , @PathVariable("docId") Long docId) {
        return appointmentService.addAppointment(appointment,patId,docId);
    }



}
