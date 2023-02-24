package ru.vasire.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.vasire.security.models.Token;

import java.util.List;
import java.util.Optional;


public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query("""
    SELECT T FROM Token as T 
    inner join User as U ON U.id = T.user.id
    WHERE U.id = :userId AND (T.expired = false OR T.revoked = false)   
"""
            )
    List<Token> findAllValidTokensByUser(Integer userId);

    Optional<Token> findByToken(String token);
}