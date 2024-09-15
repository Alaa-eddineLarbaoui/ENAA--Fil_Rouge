package com.example.ENAA__Fil_Rouge.dto;

import com.example.ENAA__Fil_Rouge.enums.Erole;
import lombok.Data;

@Data
public class SingUpDto {
    private String username;
    private String password;
    private String email;
    private Erole role;
}
