package com.example.docnet.services;

import com.example.docnet.models.Patient;
import com.example.docnet.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;  // Injection de dépendance pour le repository Patient

    /**
     * Enregistre un nouveau patient dans la base de données.
     * @param patient Le patient à enregistrer.
     * @return Le patient enregistré.
     */
    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }


    /**
     * Récupère tous les patients depuis la base de données.
     * @return Une liste de tous les patients.
     */
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }


    /**
     * Récupère un patient spécifique en utilisant son identifiant.
     * @param id L'identifiant du patient à récupérer.
     * @return Le patient correspondant à l'identifiant fourni.
     */
    public Patient showPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow();  // Lève une exception si le patient n'est pas trouvé
    }


    /**
     * Met à jour un patient existant avec de nouvelles informations.
     * @param id L'identifiant du patient à mettre à jour.
     * @param updatedPatient Le patient contenant les nouvelles informations.
     * @return Le patient mis à jour.
     */
    public Patient updatePatient(Long id, Patient updatedPatient) {
        Patient patient = showPatientById(id);  // Récupère le patient à partir de l'identifiant

        // Mise à jour des champs du patient existant
        patient.setUsername(updatedPatient.getUsername());
        patient.setEmail(updatedPatient.getEmail());
        patient.setPassword(updatedPatient.getPassword());
        patient.setPhoneNumber(updatedPatient.getPhoneNumber());
        patient.setAddress(updatedPatient.getAddress());
        patient.setBirthDate(updatedPatient.getBirthDate());
        patient.setGender(updatedPatient.getGender());

        return patientRepository.save(patient);  // Sauvegarde les modifications dans la base de données
    }


    /**
     * Supprime un patient de la base de données en utilisant son identifiant.
     * @param id L'identifiant du patient à supprimer.
     */
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
