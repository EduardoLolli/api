package autoficha.api.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import autoficha.api.domain.jogador.JogadorRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.experimental.var;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  @Autowired
  private TokenService tokenService;

  @Autowired
  private JogadorRepository repository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws IOException, ServletException {
    var tokenJWT = catchToken(request);

    if (tokenJWT != null) {
      var subject = tokenService.getSubjectToken(tokenJWT);
      var player = repository.findByEmail(subject);
      var authentication = new UsernamePasswordAuthenticationToken(player, null, player.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication((authentication));
    }

    filterChain.doFilter(request, response);
  }

  private String catchToken(HttpServletRequest request) {
    var authHeader = request.getHeader("Authorization");
    if (authHeader != null) {
      return authHeader.replace("Bearer ", "");
    }
    return null;
  }

}
