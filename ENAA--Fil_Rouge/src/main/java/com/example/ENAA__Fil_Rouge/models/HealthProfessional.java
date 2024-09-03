package com.example.ENAA__Fil_Rouge.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

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

    // Relationship with Notification
//    @OneToMany(mappedBy = "healthProfessional")
//    private List<Notification> notifications;
}
