package com.example.docnet.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JwtDto {
    private long userId;
    private String token;
}
