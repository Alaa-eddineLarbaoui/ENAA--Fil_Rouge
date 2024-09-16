package com.example.ENAA__Fil_Rouge.models;

import com.example.ENAA__Fil_Rouge.enums.Speciality;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class HealthProfessional extends Person {
    @Column
    private String bio ;

    @Column
    private String clinicAddress;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Speciality specialty;

    @Column
    private String registrationNumber;

    @Column
    private double  latitude;

    @Column
    private double  longitude;





    // Relationship with Notification
//    @OneToMany(mappedBy = "healthProfessional")
//    private List<Notification> notifications;


    @OneToMany(mappedBy = "professional")
    @JsonIgnore
    private List<Availability> availabilities;
}
