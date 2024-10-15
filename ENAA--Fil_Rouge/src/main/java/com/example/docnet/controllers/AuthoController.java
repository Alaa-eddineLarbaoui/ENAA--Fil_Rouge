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

    public AuthoController(AuthenticationManager authenticationManager, PersoneRepository personeRepository, PersonneService personneService) {
        this.authenticationManager = authenticationManager;
        this.personeRepository = personeRepository;
        this.personneService = personneService;
    }


    @PostMapping("/login")
    public JwtDto login(@RequestBody LoginPersonDto loginPersonDto) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginPersonDto.getUsername(), loginPersonDto.getPassword())
        );

        Person person1 = personeRepository.findByUsername(loginPersonDto.getUsername());
        Erole role= person1.getRole();
        long userId = person1.getId();
        String token = JwtAuth.generateToken(loginPersonDto.getUsername(),role);
        return new JwtDto(userId , token);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SingUpDto singUpDto) throws JsonProcessingException {
        return ResponseEntity.ok(personneService.register(singUpDto));
    }
    @PostMapping("/signupdoctor")
    public ResponseEntity<String> signup(@RequestBody Signupdoctor singUpDto) throws JsonProcessingException {
        return ResponseEntity.ok(personneService.registerDoctor(singUpDto));
    }



}
