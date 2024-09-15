package com.example.ENAA__Fil_Rouge.services;

import com.example.ENAA__Fil_Rouge.models.Admin;
import com.example.ENAA__Fil_Rouge.models.HealthProfessional;
import com.example.ENAA__Fil_Rouge.models.Patient;
import com.example.ENAA__Fil_Rouge.models.Person;
import com.example.ENAA__Fil_Rouge.dto.SingUpDto;
import com.example.ENAA__Fil_Rouge.repositories.PersoneRepository;
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

    private Person createUserByRole(SingUpDto request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        Person person = switch (request.getRole()) {
            case ADMIN -> new Admin();
            case DOCTOR -> new HealthProfessional();
            default -> new Patient();
        };

        person.setUsername(request.getUsername());
        person.setEmail(request.getEmail());
        person.setPassword(encodedPassword);
        System.out.println(person.getRole()+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
        person.setRole(request.getRole());

        return person;
    }
}
