package autoficha.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import autoficha.api.domain.login.LoginRecord;
import autoficha.api.infra.security.TokenJWTData;
import autoficha.api.infra.security.TokenService;
import autoficha.api.model.Jogador;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
  @Autowired
  private AuthenticationManager manager;

  @Autowired
  private TokenService tokenService;

  @PostMapping
  public ResponseEntity fazLogin(@RequestBody @Valid LoginRecord dados) {
    var authToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
    var autentication = manager.authenticate(authToken);
    var tokenJTW = tokenService.TokenGen((Jogador) autentication.getPrincipal());
    return ResponseEntity.ok(new TokenJWTData(tokenJTW));
  }
}
