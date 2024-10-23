package com.example.docnet.controllers;

import com.example.docnet.config.JwtAuth;
import com.example.docnet.dto.JwtDto;
import com.example.docnet.dto.LoginPersonDto;
import com.example.docnet.dto.Signupdoctor;
import com.example.docnet.dto.SingUpDto;
import com.example.docnet.enums.Erole;
import com.example.docnet.models.Person;
import com.example.docnet.repositories.PersoneRepository;
import com.example.docnet.services.PersonneService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthoController {

    private final AuthenticationManager authenticationManager;
    private final PersoneRepository personeRepository;
    private final PersonneService personneService;

    // Constructor injecting the AuthenticationManager, PersoneRepository, and PersonneService.
    public AuthoController(AuthenticationManager authenticationManager, PersoneRepository personeRepository, PersonneService personneService) {
        this.authenticationManager = authenticationManager;
        this.personeRepository = personeRepository;
        this.personneService = personneService;
    }

    /**
     * Handles user login by authenticating the user and generating a JWT token.
     *
     * @param loginPersonDto The login information containing the username and password.
     * @return A JWT token along with the user's ID.
     */
    @PostMapping("/login")
    public JwtDto login(@RequestBody LoginPersonDto loginPersonDto) {

        // Authenticate the user based on their username and password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginPersonDto.getUsername(), loginPersonDto.getPassword())
        );

        // Retrieve the person entity from the repository by username
        Person person1 = personeRepository.findByUsername(loginPersonDto.getUsername());

        // Get the user's role and ID
        Erole role = person1.getRole();
        long userId = person1.getId();

        // Generate a JWT token using the username and role
        String token = JwtAuth.generateToken(loginPersonDto.getUsername(), role);

        // Return a JwtDto containing the user's ID and token
        return new JwtDto(userId, token);
    }

    /**
     * Handles user registration (signup).
     *
     * @param singUpDto The registration information for a regular user.
     * @return A response entity with the result of the registration process.
     * @throws JsonProcessingException If there is an issue processing the registration data.
     */
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SingUpDto singUpDto) throws JsonProcessingException {
        // Call the service to register the user and return a response with the result
        return ResponseEntity.ok(personneService.register(singUpDto));
    }

    /**
     * Handles doctor registration (signup).
     *
     * @param singUpDto The registration information for a doctor.
     * @return A response entity with the result of the registration process.
     * @throws JsonProcessingException If there is an issue processing the registration data.
     */
    @PostMapping("/signupdoctor")
    public ResponseEntity<String> signup(@RequestBody Signupdoctor singUpDto) throws JsonProcessingException {
        // Call the service to register the doctor and return a response with the result
        return ResponseEntity.ok(personneService.registerDoctor(singUpDto));
    }

}
