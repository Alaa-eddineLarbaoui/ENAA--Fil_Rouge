package com.example.ENAA__Fil_Rouge.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JwtDto {
    private long userId;
    private String token;
}
