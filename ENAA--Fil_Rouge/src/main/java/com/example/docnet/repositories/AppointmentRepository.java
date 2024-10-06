package com.example.docnet.repositories;

import com.example.docnet.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDateAndTimeIn(LocalDate date, List<LocalTime> times);


    @Query(value = "SELECT * FROM appointment a WHERE a.date < :dans48heurs AND a.date > :maintenant AND a.notification_envoyee = false", nativeQuery = true)
    List<Appointment> findByDateAndTimeBeforeAndNotificationEnvoyeeFalse(@Param("dans48heurs") LocalDate date1, @Param("maintenant") LocalDate date2);


    List<Appointment> findByDateAndProfessionalId(LocalDate date, Long professionalId);



}
