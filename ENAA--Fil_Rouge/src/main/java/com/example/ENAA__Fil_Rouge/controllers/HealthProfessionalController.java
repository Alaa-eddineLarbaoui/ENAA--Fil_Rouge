package com.example.ENAA__Fil_Rouge.controllers;

import com.example.ENAA__Fil_Rouge.enums.Speciality;
import com.example.ENAA__Fil_Rouge.models.HealthProfessional;
import com.example.ENAA__Fil_Rouge.services.HealthProfessionalService;
import jakarta.mail.internet.HeaderTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
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


    @GetMapping("/filter")
    public List<HealthProfessional> search (@RequestParam (required = false) Speciality speciality ,
                                            @RequestParam (required = false) String  clinicAddress ) {

        return healthProfessionalService.filterDoctor(speciality  , clinicAddress);}
}

