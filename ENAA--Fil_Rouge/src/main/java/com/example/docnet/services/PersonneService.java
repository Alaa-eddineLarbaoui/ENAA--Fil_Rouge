package com.example.docnet.services;

import com.example.docnet.dto.Signupdoctor;
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

    /**
     * Data repository for Person entities.
     */
    @Autowired
    private PersoneRepository personeRepository;

    /**
     * Password encoder to secure login information.
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * Registers a new person in the database based on their role.
     * @param request Object containing the person's signup information.
     * @return A JSON message indicating that signup was successful.
     * @throws JsonProcessingException If an error occurs during JSON conversion.
     */
    public String register(SingUpDto request) throws JsonProcessingException {
        Person person = createUserByRole(request);
        personeRepository.save(person);

        Map<String, String> response = new HashMap<>();
        response.put("message", "person signup");

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(response);
    }

    /**
     * Creates a Person instance based on the role specified in the SingUpDto object.
     * @param singUpDto Object containing signup information.
     * @return A Person instance with the defined information.
     */
    private Person createUserByRole(SingUpDto singUpDto) {
        String encodedPassword = passwordEncoder.encode(singUpDto.getPassword());

        Person person = switch (singUpDto.getRole()) {
            case DOCTOR -> new HealthProfessional();
            default -> new Patient();
        };

        person.setUsername(singUpDto.getUsername());
        person.setEmail(singUpDto.getEmail());
        person.setPassword(encodedPassword);
        System.out.println(person.getRole() + " - Role assigned to the user.");
        person.setRole(singUpDto.getRole());
        return person;
    }

    /**
     * Registers a new doctor in the database.
     * @param request Object containing the doctor's signup information.
     * @return A JSON message indicating that signup was successful.
     * @throws JsonProcessingException If an error occurs during JSON conversion.
     */
    public String registerDoctor(Signupdoctor request) throws JsonProcessingException {
        Person person = createUserByRolee(request);
        personeRepository.save(person);

        Map<String, String> response = new HashMap<>();
        response.put("message", "person signup");

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(response);
    }

    /**
     * Creates a Person instance based on the role specified in the Signupdoctor object.
     * @param signupdoctor Object containing the doctor's signup information.
     * @return A Person instance with the defined information.
     */
    private Person createUserByRolee(Signupdoctor signupdoctor) {
        String encodedPassword = passwordEncoder.encode(signupdoctor.getPassword());

        Person person = switch (signupdoctor.getRole()) {
            case DOCTOR -> new HealthProfessional();
            default -> new Patient();
        };

        person.setUsername(signupdoctor.getUsername());
        person.setEmail(signupdoctor.getEmail());
        person.setPassword(encodedPassword);
        person.setRole(signupdoctor.getRole());

        System.out.println(person.getRole() + " - Role assigned to the user.");

        return person;
    }
}
