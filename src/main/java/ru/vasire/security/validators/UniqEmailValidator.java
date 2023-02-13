package ru.vasire.security.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vasire.security.services.AuthenticationService;

@Component
public class UniqEmailValidator  implements ConstraintValidator<UniqEmail, String>
{
    private AuthenticationService authenticationService;

    @Autowired
    public UniqEmailValidator(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !authenticationService.isUserRegistredByUsername(email);
    }
}
