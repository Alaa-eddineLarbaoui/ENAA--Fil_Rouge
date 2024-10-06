package com.example.docnet.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient extends Person {
    @Column
    private String address;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column
    private String gender;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Notification> notifications;

//    @ManyToOne
//    @JoinColumn(name = "doctor_id")
//    private HealthProfessional healthProfessional;
}
