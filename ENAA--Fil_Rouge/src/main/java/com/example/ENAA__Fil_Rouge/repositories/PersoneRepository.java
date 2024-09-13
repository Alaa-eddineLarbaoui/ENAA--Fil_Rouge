package com.example.ENAA__Fil_Rouge.repositories;

import com.example.ENAA__Fil_Rouge.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersoneRepository extends JpaRepository<Person ,Integer> {
    Person findByUsername(String username);

    //boolean existsByEmail(String email);
}
