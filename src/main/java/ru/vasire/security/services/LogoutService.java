package ru.vasire.security.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.vasire.security.repositories.TokenRepository;

@Service
@RequiredArgsConstructor
public class LogoutService implements org.springframework.security.web.authentication.logout.LogoutHandler {

    private final TokenRepository tokenRepository;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
    {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        if(authHeader == null || !authHeader.startsWith("Bearer "))
        {
            return;
        }
        jwt = authHeader.substring(7);
        var tokenFromRepo = tokenRepository.findByToken(jwt).orElse(null);
        if(tokenFromRepo != null){
            tokenFromRepo.setExpired(true);
            tokenFromRepo.setRevoked(true);
            tokenRepository.save(tokenFromRepo);
        }
    }
}
