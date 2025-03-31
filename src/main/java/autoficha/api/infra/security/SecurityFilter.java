package autoficha.api.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.experimental.var;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  @Autowired
  private TokenService tokenService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws IOException, ServletException {
    var tokenJWT = catchToken(request);
    var subject = tokenService.getSubjectToken(tokenJWT);

    

    filterChain.doFilter(request, response);
  }

  private String catchToken(HttpServletRequest request) {
    var authHeader = request.getHeader("Authorization");
    if (authHeader == null) {
      throw new RuntimeException("Token não enviado no cabeçalho Authorization");
    }
    return authHeader.replace("Bearer ", "");
  }

}
