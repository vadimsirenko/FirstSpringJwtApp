package ru.vasire.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import ru.vasire.security.validators.UniqEmail;


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
    @Email(message = "{user.email.incorrect}")

    @NotEmpty(message ="Поле EMAIL обязательное")
    @UniqEmail()
    private String email;

    public RegisterRequest() {
    }

    public RegisterRequest(String password, String firstName, String lastName, String email) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisterRequest)) return false;

        RegisterRequest that = (RegisterRequest) o;

        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        int result = password != null ? password.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
