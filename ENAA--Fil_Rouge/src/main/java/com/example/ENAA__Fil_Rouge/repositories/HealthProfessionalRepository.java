package com.example.ENAA__Fil_Rouge.repositories;

import com.example.ENAA__Fil_Rouge.models.HealthProfessional;
import jakarta.validation.ReportAsSingleViolation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface HealthProfessionalRepository  extends JpaRepository<HealthProfessional,Long> {
}
