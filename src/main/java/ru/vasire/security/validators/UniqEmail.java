package ru.vasire.security.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=UniqEmailValidator.class)
public @interface UniqEmail {

    String message() default "{user.duplicate}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
