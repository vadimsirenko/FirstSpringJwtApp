package ru.vasire.security.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vasire.security.services.AuthenticationService;

@Component
@RequiredArgsConstructor
public class UniqEmailValidator  implements ConstraintValidator<UniqEmail, String>
{
    private final AuthenticationService authenticationService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !authenticationService.isUserRegistredByUsername(email);
    }
}
