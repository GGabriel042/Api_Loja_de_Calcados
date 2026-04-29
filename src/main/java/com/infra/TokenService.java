package com.infra;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.usuarios.Usuario;

@Service
public class TokenService {
    
    public String gerarToken(Usuario usuario) {
        try { 
            var algorithm = Algorithm.HMAC256("senha123");
            return JWT.create()
                .withIssuer("Calcados_api")
                .withSubject(usuario.getUsername())
                .withExpiresAt(dataExpiração())
                .sign(algorithm);
            
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar token", e);
        }
    }

    private Instant dataExpiração() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
