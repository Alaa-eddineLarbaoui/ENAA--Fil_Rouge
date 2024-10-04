
package com.example.docnet.repositories;

import com.example.docnet.models.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability ,Long> {

    List<Availability> findByDateAndProfessionalId(LocalDate date, Long professionalId);

}