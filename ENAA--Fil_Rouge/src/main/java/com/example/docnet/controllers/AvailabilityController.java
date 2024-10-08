package com.example.docnet.controllers;

import com.example.docnet.models.Availability;
import com.example.docnet.dto.AvailabilityDto;
import com.example.docnet.mapper.AvailabilityMapper;
import com.example.docnet.services.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/availabilities")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private AvailabilityMapper availabilityMapper;

    // Méthode pour créer une disponibilité avec des variables de chemin

    @PostMapping("/create/{professionalId}")
    public Availability createAvailability(
            @RequestBody AvailabilityDto availabilityDto,
            @PathVariable("professionalId") Long professionalId) {
        Availability availability = availabilityMapper.toEntity(availabilityDto);
        return availabilityService.createAvailability(availability, professionalId);
    }


    // Endpoint pour récupérer les créneaux disponibles pour un médecin à une date donnée
    @GetMapping("/available-times")
    public List<LocalTime> getAvailableTimes(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam("professionalId") Long professionalId) {
        return availabilityService.getAvailableTimes(date, professionalId);
    }
}