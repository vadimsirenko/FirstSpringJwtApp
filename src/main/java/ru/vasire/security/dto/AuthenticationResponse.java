package ru.vasire.security.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class AuthenticationResponse {
    private String token;
}
