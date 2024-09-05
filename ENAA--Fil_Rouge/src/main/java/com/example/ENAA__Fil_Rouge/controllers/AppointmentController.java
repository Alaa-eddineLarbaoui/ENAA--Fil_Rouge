package com.example.ENAA__Fil_Rouge.controllers;

import com.example.ENAA__Fil_Rouge.models.Appointment;
import com.example.ENAA__Fil_Rouge.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/add")
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        return appointmentService.addAppointment(appointment);
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



    // Récupérer les créneaux disponibles pour une date donnée
    @GetMapping("/available-times")
    public List<LocalTime> getAvailableTimes(@RequestParam("date") String date) {
        LocalDate appointmentDate = LocalDate.parse(date);
        return appointmentService.getAvailableTimes(appointmentDate);
    }

    // Réserver un créneau
//    @PostMapping("/reserve")
//    public void reserveAppointment(@RequestParam("date") String date,
//                                   @RequestParam("time") String time,
//                                   @RequestParam("patientId") Long patientId) {
//        LocalDate appointmentDate = LocalDate.parse(date);
//        LocalTime appointmentTime = LocalTime.parse(time);
//        appointmentService.reserveAppointment(appointmentDate, appointmentTime, patientId);
//    }
    @PostMapping("/reserve/{date}/{time}/{patientId}")
    public void reserveAppointment(@PathVariable("date") String date,
                                   @PathVariable("time") String time,
                                   @PathVariable("patientId") Long patientId) {
        LocalDate appointmentDate = LocalDate.parse(date);
        LocalTime appointmentTime = LocalTime.parse(time);
        appointmentService.reserveAppointment(appointmentDate, appointmentTime, patientId);
    }

}
