package com.example.ENAA__Fil_Rouge.controllers;

import com.example.ENAA__Fil_Rouge.config.JwtAuth;
import com.example.ENAA__Fil_Rouge.dto.JwtDto;
import com.example.ENAA__Fil_Rouge.dto.LoginPersonDto;
import com.example.ENAA__Fil_Rouge.dto.SingUpDto;
import com.example.ENAA__Fil_Rouge.enums.Erole;
import com.example.ENAA__Fil_Rouge.models.Person;
import com.example.ENAA__Fil_Rouge.repositories.PersoneRepository;
import com.example.ENAA__Fil_Rouge.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthoController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PersoneRepository personeRepository;

    @Autowired
    private PersonneService personneService;




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
    public ResponseEntity<String> signup(@RequestBody SingUpDto singUpDto){
        return ResponseEntity.ok(personneService.register(singUpDto));
    }


}
