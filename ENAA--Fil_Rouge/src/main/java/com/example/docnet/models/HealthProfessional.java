package com.example.docnet.models;

import com.example.docnet.enums.Localisation;
import com.example.docnet.enums.Speciality;
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
     private Localisation localisation;


    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Speciality specialty;


    @Column
    private String registrationNumber;

    @Column
    private double  latitude;

    @Column
    private double  longitude;

    @Column
    private Long  price;

    @Column
    private String formation;


    // Relationship with Notification
//    @OneToMany(mappedBy = "healthProfessional")
//    private List<Notification> notifications;


    @OneToMany(mappedBy = "professional")
    @JsonIgnore
    private List<Availability> availabilities;




}
