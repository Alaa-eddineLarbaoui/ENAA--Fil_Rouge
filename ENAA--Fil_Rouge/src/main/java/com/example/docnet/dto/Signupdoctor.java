package com.example.docnet.dto;

import com.example.docnet.enums.Erole;
import com.example.docnet.enums.Localisation;
import com.example.docnet.enums.Speciality;

import lombok.Data;

@Data
public class Signupdoctor {
    private String username;
    private String password;
    private String email;
    private Erole role;
    private String clinicAddress;
    private Localisation localisation;
    private Speciality specialty;

}

