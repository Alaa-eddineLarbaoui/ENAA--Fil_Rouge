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

    public HealthProfessionalController(HealthProfessionalService healthProfessionalService) {
        this.healthProfessionalService = healthProfessionalService;
    }

    @PostMapping("/register")
    public HealthProfessional registerHealthProfessional(@RequestBody HealthProfessional healthProfessional) {
        return healthProfessionalService.registerHealthProfessional(healthProfessional);
    }

    @GetMapping("/getAll")
    public List<HealthProfessional> getAllHealthProfessionals() {
        return healthProfessionalService.getAllHealthProfessionals();
    }

    @GetMapping("/get/{id}")
    public HealthProfessional getHealthProfessionalById(@PathVariable Long id) {
        return healthProfessionalService.showHealthProfessionalById(id);
    }

    @PutMapping("/update/{id}")
    public HealthProfessional updateHealthProfessional(@PathVariable Long id, @RequestBody HealthProfessional updatedHealthProfessional) {
        return healthProfessionalService.updateHealthProfessional(id, updatedHealthProfessional);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHealthProfessional(@PathVariable Long id) {
        healthProfessionalService.deleteHealthProfessional(id);
    }


    @GetMapping("/filter")
    public List<HealthProfessional> search (@RequestParam (required = false) Speciality speciality ,
                                            @RequestParam (required = false) String  clinicAddress ) {

        return healthProfessionalService.filterDoctor(speciality , clinicAddress);
    }

}

