package com.example.docnet.services;


import com.example.docnet.dto.AvailabilityDto1;
import com.example.docnet.exceptions.HealthProfessionalNotFoundException;
import com.example.docnet.mapper.AvailabilityMapper1;
import com.example.docnet.models.Appointment;
import com.example.docnet.models.Availability;
import com.example.docnet.models.HealthProfessional;
import com.example.docnet.repositories.AppointmentRepository;
import com.example.docnet.repositories.AvailabilityRepository;
import com.example.docnet.repositories.HealthProfessionalRepository;
import com.example.docnet.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public AvailabilityService(AppointmentRepository appointmentRepository, PatientRepository patientRepository, HealthProfessionalRepository professionalRepository, AvailabilityRepository availabilityRepository) {
        this.appointmentRepository = appointmentRepository;
        this.professionalRepository = professionalRepository;
        this.availabilityRepository = availabilityRepository;
    }


    public List<AvailabilityDto1> getAvailableTimes(LocalDate date, Long professionalId) {

        List<Appointment> reservedAppointments = appointmentRepository.findByDateAndProfessionalId(date, professionalId);


        List<LocalTime> reservedTimes = reservedAppointments.stream()
                .map(Appointment::getTime)
                .toList();


        List<AvailabilityDto1> availabilities = availabilityRepository.findByDateAndProfessionalId(date, professionalId);


        return availabilities.stream()
                .filter(availability -> !reservedTimes.contains(availability.getStartTime()))
                .map(availability -> new AvailabilityDto1(availability.getId(), availability.getStartTime()))
                .collect(Collectors.toList());
    }




    public Availability createAvailability(Availability availability, Long professionalId) {
        HealthProfessional healthProfessional = professionalRepository.findById(professionalId)
                .orElseThrow(() -> new HealthProfessionalNotFoundException(professionalId));
        availability.setProfessional(healthProfessional);
        return availabilityRepository.save(availability);
    }
    public void deleteAvaibilityTime(Long idAvailability) {
        availabilityRepository.deleteById(idAvailability);
    }

}

