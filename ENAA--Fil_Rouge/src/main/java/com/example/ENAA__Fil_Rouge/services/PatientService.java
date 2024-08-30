package com.example.ENAA__Fil_Rouge.services;

import com.example.ENAA__Fil_Rouge.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;


}
