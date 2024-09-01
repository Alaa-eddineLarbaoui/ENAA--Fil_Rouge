package com.example.ENAA__Fil_Rouge.models;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String message;

    @Column
    private LocalDateTime dateSend;

    @Column
    private boolean isSent;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}

