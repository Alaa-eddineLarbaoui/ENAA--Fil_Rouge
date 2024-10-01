package com.example.ENAA__Fil_Rouge.repositories;

import com.example.ENAA__Fil_Rouge.models.HealthProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;



public interface HealthProfessionalRepository  extends JpaRepository<HealthProfessional,Long> , QuerydslPredicateExecutor<HealthProfessional> {

}
