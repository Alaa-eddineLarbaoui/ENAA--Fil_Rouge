package com.example.ENAA__Fil_Rouge.models;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthProfessional extends Person {
    @Id
    @Column
    private String clinicAddress ;

    @Column
    private String specialty ;

    @Column
    private String registrationNumber;


}
