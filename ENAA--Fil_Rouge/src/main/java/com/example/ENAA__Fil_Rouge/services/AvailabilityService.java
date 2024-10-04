package com.example.ENAA__Fil_Rouge.services;


import com.example.ENAA__Fil_Rouge.models.Appointment;
import com.example.ENAA__Fil_Rouge.models.Availability;
import com.example.ENAA__Fil_Rouge.models.HealthProfessional;
import com.example.ENAA__Fil_Rouge.repositories.AppointmentRepository;
import com.example.ENAA__Fil_Rouge.repositories.AvailabilityRepository;
import com.example.ENAA__Fil_Rouge.repositories.HealthProfessionalRepository;
import com.example.ENAA__Fil_Rouge.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailabilityService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private HealthProfessionalRepository professionalRepository;

    @Autowired
    private AvailabilityRepository availabilityRepository;


    public List<LocalTime> getAvailableTimes(LocalDate date, Long professionalId) {
        List<Appointment> reservedAppointments = appointmentRepository.findByDateAndProfessionalId(date, professionalId);
        List<LocalTime> reservedTimes = reservedAppointments.stream()
                .map(Appointment::getTime)
                .collect(Collectors.toList());

        List<Availability> availabilities = availabilityRepository.findByDateAndProfessionalId(date, professionalId);

        // Filtrer les créneaux disponibles en fonction des réservations déjà effectuées
        return availabilities.stream()
                .filter(availability -> !reservedTimes.contains(availability.getStartTime()))
                .map(Availability::getStartTime)
                .collect(Collectors.toList());
    }


    public Availability createAvailability(Availability availability, Long professionalId) {
        HealthProfessional healthProfessional = professionalRepository.findById(professionalId).orElseThrow();
        availability.setProfessional(healthProfessional);
        return availabilityRepository.save(availability);
    }
    public void deleteAvaibilityTime(Long idAvailability){
        availabilityRepository.deleteById(idAvailability);
    }
}

