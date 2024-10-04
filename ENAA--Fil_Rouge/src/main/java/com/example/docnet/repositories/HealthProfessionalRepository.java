package com.example.docnet.repositories;

import com.example.docnet.models.HealthProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;



public interface HealthProfessionalRepository  extends JpaRepository<HealthProfessional,Long> , QuerydslPredicateExecutor<HealthProfessional> {

}
