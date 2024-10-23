package com.example.docnet.controllers;

import com.example.docnet.dto.AvailabilityDto1;
import com.example.docnet.models.Availability;
import com.example.docnet.dto.AvailabilityDto;
import com.example.docnet.mapper.AvailabilityMapper;
import com.example.docnet.services.AvailabilityService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/availabilities")
public class AvailabilityController {

    private final AvailabilityService availabilityService;
    private final AvailabilityMapper availabilityMapper;

    // Constructor injecting AvailabilityService and AvailabilityMapper.
    public AvailabilityController(AvailabilityService availabilityService, AvailabilityMapper availabilityMapper) {
        this.availabilityService = availabilityService;
        this.availabilityMapper = availabilityMapper;
    }

    /**
     * Creates a new availability for a specific health professional.
     *
     * @param availabilityDto The availability information to create.
     * @param professionalId The ID of the health professional.
     * @return The newly created availability.
     */
    @PostMapping("/create/{professionalId}")
    public Availability createAvailability(
            @RequestBody AvailabilityDto availabilityDto,
            @PathVariable("professionalId") Long professionalId) {
        // Convert the DTO to the Availability entity
        Availability availability = availabilityMapper.toEntity(availabilityDto);
        // Call the service to create availability for the given professional
        return availabilityService.createAvailability(availability, professionalId);
    }

    /**
     * Retrieves available times for a specific health professional on a given date.
     *
     * @param date The date to check for availability.
     * @param professionalId The ID of the health professional.
     * @return The list of available times in DTO format.
     */
    @GetMapping("/available-times")
    public List<AvailabilityDto1> getAvailableTimes(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam("professionalId") Long professionalId) {
        // Call the service to get available times for the specified date and professional
        return availabilityService.getAvailableTimes(date, professionalId);
    }

    /**
     * Deletes a specific availability by its ID.
     *
     * @param id The ID of the availability to delete.
     */
    @DeleteMapping("delete/{id}")
    public void deleteTime(@PathVariable Long id) {
        // Call the service to delete the availability by its ID
        availabilityService.deleteAvaibilityTime(id);
    }
}
