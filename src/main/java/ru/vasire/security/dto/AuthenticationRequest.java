package ru.vasire.security.dto;

import jakarta.validation.constraints.NotEmpty;

public class AuthenticationRequest {

    @NotEmpty(message ="Поле PASSWORD обязательное")
    private String password;

    @NotEmpty(message ="Поле EMAIL обязательное")
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AuthenticationRequest(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public AuthenticationRequest() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthenticationRequest)) return false;

        AuthenticationRequest that = (AuthenticationRequest) o;

        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        int result = password != null ? password.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
