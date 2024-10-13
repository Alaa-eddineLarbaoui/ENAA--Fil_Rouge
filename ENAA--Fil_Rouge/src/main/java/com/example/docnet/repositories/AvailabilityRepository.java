
package com.example.docnet.repositories;

import com.example.docnet.dto.AvailabilityDto1;
import com.example.docnet.models.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability ,Long> {

    List<AvailabilityDto1> findByDateAndProfessionalId(LocalDate date, Long professionalId);
    List<AvailabilityDto1> findByProfessionalId(Long professionalId);
}