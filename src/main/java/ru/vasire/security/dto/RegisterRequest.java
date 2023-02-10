package ru.vasire.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import ru.vasire.security.validators.UniqEmail;

@Getter
@Setter
@Builder
public class RegisterRequest {
    @Size(min = 5, max = 14, message = "Поле PASSWORD должно содержать от 5 до 14 символов")
    @NotEmpty(message ="Поле PASSWORD обязательное")
    private String password;
    @Size(min = 1, max = 20, message = "Поле FIRSTNAME должно содержать от 1 до 20 символов")

    @NotEmpty(message ="Поле FIRSTNAME обязательное")
    private String firstName;
    @Size(min = 1, max = 20, message = "Поле LASTNAME должно содержать от 1 до 20 символов")

    @NotEmpty(message ="Поле LASTNAME обязательное")
    private String lastName;
    @Email(message = "Не коректный адрес EMAIL")

    @NotEmpty(message ="Поле EMAIL обязательное")
    @UniqEmail()
    private String email;
}