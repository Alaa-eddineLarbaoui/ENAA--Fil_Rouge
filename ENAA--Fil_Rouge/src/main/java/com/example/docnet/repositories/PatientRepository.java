package com.example.docnet.repositories;

import com.example.docnet.models.Patient;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
 }
