package com.example.docnet.repositories;

import com.example.docnet.models.HealthProfessional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;


public interface HealthProfessionalRepository  extends JpaRepository<HealthProfessional,Long> , QuerydslPredicateExecutor<HealthProfessional> {
}
