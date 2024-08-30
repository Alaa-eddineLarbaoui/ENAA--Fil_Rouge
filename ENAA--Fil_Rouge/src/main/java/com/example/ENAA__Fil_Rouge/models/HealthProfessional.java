package com.example.ENAA__Fil_Rouge.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HealthProfessional extends Person {
    @Column
    private String clinicAddress;

    @Column
    private String specialty;

    @Column
    private String registrationNumber;
}
