package com.example.docnet.services;

import com.example.docnet.dto.AvailabilityDto1;
import com.example.docnet.exceptions.HealthProfessionalNotFoundException;
import com.example.docnet.models.Appointment;
import com.example.docnet.models.Availability;
import com.example.docnet.models.HealthProfessional;
import com.example.docnet.repositories.AppointmentRepository;
import com.example.docnet.repositories.AvailabilityRepository;
import com.example.docnet.repositories.HealthProfessionalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailabilityService {

    private final AppointmentRepository appointmentRepository;
    private final HealthProfessionalRepository professionalRepository;
    private final AvailabilityRepository availabilityRepository;

    public AvailabilityService(AppointmentRepository appointmentRepository,
                               HealthProfessionalRepository professionalRepository,
                               AvailabilityRepository availabilityRepository) {
        this.appointmentRepository = appointmentRepository;
        this.professionalRepository = professionalRepository;
        this.availabilityRepository = availabilityRepository;
    }

    /**
     * Retrieves available times for a specific health professional on a given date.
     * Filters out times that are already reserved by appointments.
     * @param date The date for which to check availability.
     * @param professionalId The ID of the health professional.
     * @return A list of available times for the specified professional on the given date.
     */
    public List<AvailabilityDto1> getAvailableTimes(LocalDate date, Long professionalId) {

        // Retrieve all appointments for the specified date and professional
        List<Appointment> reservedAppointments = appointmentRepository.findByDateAndProfessionalId(date, professionalId);

        // Extract the times of reserved appointments to filter out later
        List<LocalTime> reservedTimes = reservedAppointments.stream()
                .map(Appointment::getTime)
                .toList();

        // Retrieve all availabilities for the specified date and professional
        List<AvailabilityDto1> availabilities = availabilityRepository.findByDateAndProfessionalId(date, professionalId);

        // Filter out reserved times from the availabilities and return the available times
        return availabilities.stream()
                .filter(availability -> !reservedTimes.contains(availability.getStartTime()))
                .map(availability -> new AvailabilityDto1(availability.getId(), availability.getStartTime()))
                .collect(Collectors.toList());
    }

    /**
     * Creates a new availability entry for a specific health professional.
     * Throws an exception if the specified health professional is not found.
     * @param availability The availability data to be saved.
     * @param professionalId The ID of the health professional for whom availability is being created.
     * @return The saved availability entry.
     */
    public Availability createAvailability(Availability availability, Long professionalId) {
        HealthProfessional healthProfessional = professionalRepository.findById(professionalId)
                .orElseThrow(() -> new HealthProfessionalNotFoundException(professionalId));
        availability.setProfessional(healthProfessional);
        return availabilityRepository.save(availability);
    }

    /**
     * Deletes a specific availability time by its ID.
     * @param idAvailability The ID of the availability entry to delete.
     */
    public void deleteAvaibilityTime(Long idAvailability) {
        availabilityRepository.deleteById(idAvailability);
    }
}
