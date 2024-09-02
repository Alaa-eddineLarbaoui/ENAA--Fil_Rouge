package com.example.ENAA__Fil_Rouge.models;

import com.example.ENAA__Fil_Rouge.enums.AppointmentReason;
import com.example.ENAA__Fil_Rouge.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

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
        private Date date;

        @Column(nullable = false)
        private Time time ;

        @Enumerated(EnumType.STRING)
        @Column(length = 20)
        private AppointmentStatus status;

        @Enumerated(EnumType.STRING)
        @Column(length = 20)
        private AppointmentReason appointmentReason;

        @Column
        private String note ;


        @ManyToOne
        @JoinColumn(name = "patient_id")
        private Patient patient;

        @ManyToOne
        @JoinColumn(name = "professional_id")
        private HealthProfessional professional;

    }
