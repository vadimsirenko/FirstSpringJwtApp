package ru.vasire.security.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationRequest {

    @NotEmpty(message ="Поле PASSWORD обязательное")
    private String password;

    @NotEmpty(message ="Поле EMAIL обязательное")
    private String email;
}
