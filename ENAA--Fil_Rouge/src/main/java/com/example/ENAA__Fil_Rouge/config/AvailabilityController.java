package com.example.ENAA__Fil_Rouge.config;

import com.example.ENAA__Fil_Rouge.models.Availability;
import com.example.ENAA__Fil_Rouge.services.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/availabilities")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    // Méthode pour créer une disponibilité avec des variables de chemin




    @PostMapping("/create/{professionalId}")
    public Availability createAvailability(
            @RequestBody Availability availability,
            @PathVariable("professionalId") Long professionalId) {
        return availabilityService.createAvailability(availability, professionalId);
    }

}