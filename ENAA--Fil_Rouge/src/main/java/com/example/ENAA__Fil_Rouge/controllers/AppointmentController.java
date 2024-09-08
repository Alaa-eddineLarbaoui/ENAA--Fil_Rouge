package com.example.ENAA__Fil_Rouge.controllers;

import com.example.ENAA__Fil_Rouge.models.Appointment;
import com.example.ENAA__Fil_Rouge.repositories.AppointmentRepository;
import com.example.ENAA__Fil_Rouge.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepository appointmentRepository;





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
