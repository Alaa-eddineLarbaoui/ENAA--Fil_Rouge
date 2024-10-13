package com.example.docnet.models;

import com.example.docnet.enums.AppointmentReason;
import com.example.docnet.enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;


    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
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
