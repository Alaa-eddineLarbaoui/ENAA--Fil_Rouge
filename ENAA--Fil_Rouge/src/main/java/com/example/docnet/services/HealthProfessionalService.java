package com.example.docnet.services;

import com.example.docnet.enums.Speciality;
import com.example.docnet.exceptions.HealthProfessionalNotFoundException;
import com.example.docnet.models.HealthProfessional;
import com.example.docnet.models.QHealthProfessional;
import com.example.docnet.repositories.HealthProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.querydsl.core.BooleanBuilder;
import java.util.List;

@Service
public class HealthProfessionalService {

    @Autowired
    private HealthProfessionalRepository healthProfessionalRepository;

    /**
     * Registers a new health professional in the database.
     * @param healthProfessional The health professional to register.
     * @return The saved health professional.
     */
    public HealthProfessional registerHealthProfessional(HealthProfessional healthProfessional) {
        return healthProfessionalRepository.save(healthProfessional);
    }

    /**
     * Retrieves all health professionals from the database.
     * @return A list of all health professionals.
     */
    public List<HealthProfessional> getAllHealthProfessionals() {
        return healthProfessionalRepository.findAll();
    }

    /**
     * Retrieves a specific health professional using their ID.
     * @param id The ID of the health professional to retrieve.
     * @return The health professional corresponding to the provided ID.
     */
    public HealthProfessional showHealthProfessionalById(Long id) {
        return healthProfessionalRepository.findById(id)
                .orElseThrow(() -> new HealthProfessionalNotFoundException(id));
    }


    /**
     * Updates an existing health professional with new information.
     * @param id The ID of the health professional to update.
     * @param updateProf The health professional containing the updated information.
     * @return The updated health professional.
     */
    public HealthProfessional updateHealthProfessional(Long id, HealthProfessional updateProf) {
        HealthProfessional healthProfessional = showHealthProfessionalById(id);

        // Update the fields of the existing health professional
        healthProfessional.setUsername(updateProf.getUsername());
        healthProfessional.setEmail(updateProf.getEmail());
        healthProfessional.setPassword(updateProf.getPassword());
        healthProfessional.setPhoneNumber(updateProf.getPhoneNumber());
        healthProfessional.setBio(updateProf.getBio());
        healthProfessional.setClinicAddress(updateProf.getClinicAddress());
        healthProfessional.setSpecialty(updateProf.getSpecialty());
        healthProfessional.setRegistrationNumber(updateProf.getRegistrationNumber());

        return healthProfessionalRepository.save(healthProfessional);
    }




    public List<HealthProfessional> filterDoctor( Speciality speciality , String clinicAddress  ) {
        QHealthProfessional healthProfessional  = QHealthProfessional.healthProfessional;
        BooleanBuilder builder = new BooleanBuilder();
        if (speciality != null) {
            builder.and(healthProfessional.specialty.eq(speciality));
        }

        if (clinicAddress != null) {
            builder.and(healthProfessional.clinicAddress.contains(clinicAddress));
        }
        return (List<HealthProfessional>) healthProfessionalRepository.findAll(builder);

    }
}
