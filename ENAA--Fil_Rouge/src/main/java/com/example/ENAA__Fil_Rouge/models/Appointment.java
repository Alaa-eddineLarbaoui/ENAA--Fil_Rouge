package com.example.ENAA__Fil_Rouge.models;

import com.example.ENAA__Fil_Rouge.enums.AppointmentReason;
import com.example.ENAA__Fil_Rouge.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private AppointmentStatus status;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private AppointmentReason appointmentReason;

    @Column
    private String note;

    @Column
    private boolean notificationEnvoyee = false;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "professional_id")
    private HealthProfessional professional;
}
