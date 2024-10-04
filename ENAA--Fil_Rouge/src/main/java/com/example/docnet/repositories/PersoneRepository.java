package com.example.docnet.repositories;

import com.example.docnet.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersoneRepository extends JpaRepository<Person ,Integer> {
    Person findByUsername(String username);

    //boolean existsByEmail(String email);
}
