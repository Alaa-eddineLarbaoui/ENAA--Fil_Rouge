package com.example.ENAA__Fil_Rouge.repositories;

import com.example.ENAA__Fil_Rouge.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
