package com.example.ENAA__Fil_Rouge.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient extends Person {
    @Column(length = 50, unique = true, nullable = false)
    private String email;

    @Column
    private String address;

    @Column
    private Date birthDate;

    @Column
    private String gender;
}
