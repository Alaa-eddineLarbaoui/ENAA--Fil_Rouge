package com.example.docnet.controllers;

import com.example.docnet.models.Patient;
import com.example.docnet.services.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/getAll")
    public List<Patient> showAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/get/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.showPatientById(id);
    }

    @PostMapping("/register")
    public Patient registerPatient(@RequestBody Patient patient) {
        return patientService.registerPatient(patient);
    }

    @PutMapping("update/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        return patientService.updatePatient(id, updatedPatient);
    }

    @DeleteMapping("delete/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
