
package com.example.ENAA__Fil_Rouge.repositories;

import com.example.ENAA__Fil_Rouge.models.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability ,Long> {

    List<Availability> findByDateAndProfessionalId(LocalDate date, Long professionalId);

}