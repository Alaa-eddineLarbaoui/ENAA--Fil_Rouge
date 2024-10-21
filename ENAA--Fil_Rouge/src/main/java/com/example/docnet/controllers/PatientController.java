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

    // Constructeur injectant le service PatientService.
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * Récupère tous les patients.
     *
     * @return La liste de tous les patients.
     */
    @GetMapping("/getAll")
    public List<Patient> showAllPatients() {
        return patientService.getAllPatients();
    }

    /**
     * Récupère un patient par son ID.
     *
     * @param id L'ID du patient à récupérer.
     * @return Le patient correspondant à l'ID.
     */
    @GetMapping("/get/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.showPatientById(id);
    }

    /**
     * Enregistre un nouveau patient.
     *
     * @param patient Les informations du patient à enregistrer.
     * @return Le patient enregistré.
     */
    @PostMapping("/register")
    public Patient registerPatient(@RequestBody Patient patient) {
        return patientService.registerPatient(patient);
    }

    /**
     * Met à jour les informations d'un patient existant.
     *
     * @param id L'ID du patient à mettre à jour.
     * @param updatedPatient Les nouvelles informations du patient.
     * @return Le patient mis à jour.
     */
    @PutMapping("update/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        return patientService.updatePatient(id, updatedPatient);
    }

    /**
     * Supprime un patient par son ID.
     *
     * @param id L'ID du patient à supprimer.
     */
    @DeleteMapping("delete/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
