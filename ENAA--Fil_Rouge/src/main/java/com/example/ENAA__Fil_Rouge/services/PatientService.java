package com.example.ENAA__Fil_Rouge.services;

import com.example.ENAA__Fil_Rouge.models.Patient;
import com.example.ENAA__Fil_Rouge.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient showPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow();
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Patient patient = showPatientById(id);
        patient.setUsername(updatedPatient.getUsername());
        patient.setEmail(updatedPatient.getEmail());
        patient.setPassword(updatedPatient.getPassword());
        patient.setPhoneNumber(updatedPatient.getPhoneNumber());
        patient.setAddress(updatedPatient.getAddress());
        patient.setBirthDate(updatedPatient.getBirthDate());
        patient.setGender(updatedPatient.getGender());
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
