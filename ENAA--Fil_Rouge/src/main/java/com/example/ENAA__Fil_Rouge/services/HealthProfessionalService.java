package com.example.ENAA__Fil_Rouge.services;

import com.example.ENAA__Fil_Rouge.enums.Speciality;
import com.example.ENAA__Fil_Rouge.models.HealthProfessional;
import com.example.ENAA__Fil_Rouge.models.QHealthProfessional;
import com.example.ENAA__Fil_Rouge.repositories.HealthProfessionalRepository;
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
                .orElseThrow();
    }

    /**
     * Updates an existing health professional with new information.
     * @param id The ID of the health professional to update.
     * @param updateProf The health professional containing the updated information.
     * @return The updated health professional.
     */
    public HealthProfessional updateHealthProfessional(Long id, HealthProfessional updateProf) {
        HealthProfessional healthProfessional = showHealthProfessionalById(id);  // Retrieves the health professional by ID

        // Update the fields of the existing health professional
        healthProfessional.setUsername(updateProf.getUsername());
        healthProfessional.setEmail(updateProf.getEmail());
        healthProfessional.setPassword(updateProf.getPassword());
        healthProfessional.setPhoneNumber(updateProf.getPhoneNumber());
        healthProfessional.setBio(updateProf.getBio());
        healthProfessional.setClinicAddress(updateProf.getClinicAddress());
        healthProfessional.setSpecialty(updateProf.getSpecialty());
        healthProfessional.setRegistrationNumber(updateProf.getRegistrationNumber());

        return healthProfessionalRepository.save(healthProfessional);  // Save the changes to the database
    }

    /**
     * Deletes a health professional from the database using their ID.
     * @param id The ID of the health professional to delete.
     */
    public void deleteHealthProfessional(Long id) {
        healthProfessionalRepository.deleteById(id);
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
