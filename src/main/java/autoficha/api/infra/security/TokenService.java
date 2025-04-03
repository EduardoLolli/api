package autoficha.api.infra.security;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import autoficha.api.model.Jogador;

@Service
public class TokenService {

  @Value("${api.infra.security.secret}")
  private String secret;

  public String TokenGen(Jogador jogador) {
    try {
      var algorithm = Algorithm.HMAC256(secret);
      return JWT.create()
          .withIssuer("Autoficha")
          .withSubject(jogador.getEmail())
          .withExpiresAt(limit())
          .sign(algorithm);
    } catch (JWTCreationException exception) {
      throw new RuntimeException("Erro ao gerar token JWT", exception);
    }
  }

  public String getSubjectToken(String tokenJWR) {
    try {
      var algorithm = Algorithm.HMAC256(secret);
      return JWT.require(algorithm)
          .withIssuer("Autoficha")
          .build()
          .verify(tokenJWR)
          .getSubject();

    } catch (JWTVerificationException exception) {
      throw new RuntimeException("Token JWT inválido ou expirado!");
    }
  }

  private Date limit() {
    return Date.from(LocalDateTime.now().plusHours(5).toInstant(ZoneOffset.of("-3")));
  }

  
}
