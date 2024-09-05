package com.example.ENAA__Fil_Rouge.repositories;

import com.example.ENAA__Fil_Rouge.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
//    List<Appointment> findByDateTimeBeforeAndNotificationEnvoyeeFalse(LocalDateTime dateTime);
    List<Appointment> findByDateAndTimeIn(LocalDate date, List<LocalTime> times);

}
