package com.example.docnet.controllers;

import com.example.docnet.enums.Speciality;
import com.example.docnet.models.HealthProfessional;
import com.example.docnet.services.HealthProfessionalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/health-professionals")
public class HealthProfessionalController {

    private final HealthProfessionalService healthProfessionalService;

    // Constructor injecting the HealthProfessionalService.
    public HealthProfessionalController(HealthProfessionalService healthProfessionalService) {
        this.healthProfessionalService = healthProfessionalService;
    }

    /**
     * Registers a new health professional.
     *
     * @param healthProfessional The health professional information to register.
     * @return The registered health professional.
     */
    @PostMapping("/register")
    public HealthProfessional registerHealthProfessional(@RequestBody HealthProfessional healthProfessional) {
        return healthProfessionalService.registerHealthProfessional(healthProfessional);
    }

    /**
     * Retrieves all health professionals.
     *
     * @return The list of all health professionals.
     */
    @GetMapping("/getAll")
    public List<HealthProfessional> getAllHealthProfessionals() {
        return healthProfessionalService.getAllHealthProfessionals();
    }

    /**
     * Retrieves a health professional by their ID.
     *
     * @param id The ID of the health professional to retrieve.
     * @return The health professional corresponding to the ID.
     */
    @GetMapping("/get/{id}")
    public HealthProfessional getHealthProfessionalById(@PathVariable Long id) {
        return healthProfessionalService.showHealthProfessionalById(id);
    }

    /**
     * Updates the information of an existing health professional.
     *
     * @param id The ID of the health professional to update.
     * @param updatedHealthProfessional The new information of the health professional.
     * @return The updated health professional.
     */
    @PutMapping("/update/{id}")
    public HealthProfessional updateHealthProfessional(@PathVariable Long id, @RequestBody HealthProfessional updatedHealthProfessional) {
        return healthProfessionalService.updateHealthProfessional(id, updatedHealthProfessional);
    }

    /**
     * Filters health professionals by speciality and/or clinic address.
     *
     * @param speciality The speciality of the health professionals (optional).
     * @param clinicAddress The clinic address (optional).
     * @return The list of health professionals matching the filtering criteria.
     */
    @GetMapping("/filter")
    public List<HealthProfessional> search(@RequestParam(required = false) Speciality speciality,
                                           @RequestParam(required = false) String clinicAddress) {
        return healthProfessionalService.filterDoctor(speciality, clinicAddress);
    }
}
