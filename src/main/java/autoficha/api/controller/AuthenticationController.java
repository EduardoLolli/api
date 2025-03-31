package autoficha.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import autoficha.api.domain.jogador.AuthenticationData;
import autoficha.api.domain.jogador.Jogador;
import autoficha.api.infra.security.TokenJWTData;
import autoficha.api.infra.security.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
  @Autowired
  private AuthenticationManager manager;

  @Autowired
  private TokenService tokenService;

  @PostMapping
  public ResponseEntity fazLogin(@RequestBody @Valid AuthenticationData dados) {
    var authToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
    var autentication = manager.authenticate(authToken);
    var tokenJTW = tokenService.TokenGen((Jogador) autentication.getPrincipal());
    return ResponseEntity.ok(new TokenJWTData(tokenJTW));
  }
}
