package com.example.docnet.services;

import com.example.docnet.models.HealthProfessional;
import com.example.docnet.models.Patient;
import com.example.docnet.models.Person;
import com.example.docnet.dto.SingUpDto;
import com.example.docnet.repositories.PersoneRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class PersonneService {
    @Autowired
    private PersoneRepository personeRepository;


    private final PasswordEncoder passwordEncoder;
    public String register(SingUpDto request) throws JsonProcessingException {
        Person person = createUserByRole(request);
        personeRepository.save(person);

        // Créer une réponse au format JSON
        Map<String, String> response = new HashMap<>();
        response.put("message", "person signup");

        // Sérialiser le Map en une chaîne JSON
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(response); // Retourner la chaîne JSON
    }
    private Person createUserByRole(SingUpDto singUpDto) {
        String encodedPassword = passwordEncoder.encode(singUpDto.getPassword());

        Person person = switch (singUpDto.getRole()) {
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
