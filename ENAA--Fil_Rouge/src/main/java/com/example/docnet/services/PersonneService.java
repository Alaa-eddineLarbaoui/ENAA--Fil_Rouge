package com.example.docnet.services;

import com.example.docnet.models.Admin;
import com.example.docnet.models.HealthProfessional;
import com.example.docnet.models.Patient;
import com.example.docnet.models.Person;
import com.example.docnet.dto.SingUpDto;
import com.example.docnet.repositories.PersoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonneService {
    @Autowired
    private PersoneRepository personeRepository;


    private final PasswordEncoder passwordEncoder;

    public String register(SingUpDto request) {
        Person person = createUserByRole(request);
        personeRepository.save(person);
        return "person signup";
    }

    private Person createUserByRole(SingUpDto singUpDto) {
        String encodedPassword = passwordEncoder.encode(singUpDto.getPassword());

        Person person = switch (singUpDto.getRole()) {
            case ADMIN -> new Admin();
            case DOCTOR -> new HealthProfessional();
            default -> new Patient();
        };

        person.setUsername(singUpDto.getUsername());
        person.setEmail(singUpDto.getEmail());
        person.setPassword(encodedPassword);
        System.out.println(person.getRole()+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
        person.setRole(singUpDto.getRole());
        return person;
    }













}
