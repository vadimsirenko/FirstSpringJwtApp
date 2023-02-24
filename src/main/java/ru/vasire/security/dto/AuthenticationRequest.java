package ru.vasire.security.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationRequest {

    @NotEmpty(message ="Поле PASSWORD обязательное")
    private String password;

    @NotEmpty(message ="Поле EMAIL обязательное")
    private String email;
}
