package com.example.ENAA__Fil_Rouge.services;

import com.example.ENAA__Fil_Rouge.models.HealthProfessional;
import com.example.ENAA__Fil_Rouge.repositories.HealthProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthProfessionalService {

    @Autowired
    private HealthProfessionalRepository healthProfessionalRepository;

    public HealthProfessional registerHealthProfessional(HealthProfessional healthProfessional) {
        return healthProfessionalRepository.save(healthProfessional);
    }

    public List<HealthProfessional> getAllHealthProfessionals() {
        return healthProfessionalRepository.findAll();
    }

    public HealthProfessional showHealthProfessionalById(Long id) {
        return healthProfessionalRepository.findById(id)
                .orElseThrow();
    }
    public HealthProfessional updateHealthProfessional(Long id, HealthProfessional updateProf) {
        HealthProfessional healthProfessional = showHealthProfessionalById(id);
        healthProfessional.setUsername(updateProf.getUsername());
        healthProfessional.setEmail(updateProf.getEmail());
        healthProfessional.setPassword(updateProf.getPassword());
        healthProfessional.setPhoneNumber(updateProf.getPhoneNumber());
        healthProfessional.setClinicAddress(updateProf.getClinicAddress());
        healthProfessional.setSpecialty(updateProf.getSpecialty());
        healthProfessional.setRegistrationNumber(updateProf.getRegistrationNumber());
        return healthProfessionalRepository.save(healthProfessional);
    }

    public void deleteHealthProfessional(Long id) {
        healthProfessionalRepository.deleteById(id);
    }
}
