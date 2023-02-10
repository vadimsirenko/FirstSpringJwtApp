package ru.vasire.security.dto;

import lombok.*;

@Getter
@Setter
@Builder
public class AuthenticationResponse {
    private String token;
}
