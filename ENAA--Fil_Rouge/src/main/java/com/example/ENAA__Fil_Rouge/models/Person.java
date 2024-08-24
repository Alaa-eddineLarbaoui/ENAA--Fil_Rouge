package com.example.ENAA__Fil_Rouge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type")
public abstract class Person  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 50, unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 15, nullable = false)
    private String phoneNumber;


}
