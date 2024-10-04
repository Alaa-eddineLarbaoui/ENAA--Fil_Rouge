package com.example.docnet.dto;

import com.example.docnet.enums.Erole;
import lombok.Data;

@Data
public class SingUpDto {
    private String username;
    private String password;
    private String email;
    private Erole role;
}
