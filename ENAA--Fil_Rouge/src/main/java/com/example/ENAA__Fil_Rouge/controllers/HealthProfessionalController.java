package com.example.ENAA__Fil_Rouge.controllers;

import com.example.ENAA__Fil_Rouge.models.HealthProfessional;
import com.example.ENAA__Fil_Rouge.services.HealthProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/health-professionals")
public class HealthProfessionalController {

    @Autowired
    private HealthProfessionalService healthProfessionalService;

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
}
