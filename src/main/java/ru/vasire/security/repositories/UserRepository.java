package ru.vasire.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasire.security.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}