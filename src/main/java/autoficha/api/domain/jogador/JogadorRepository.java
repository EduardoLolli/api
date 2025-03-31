package autoficha.api.domain.jogador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

  UserDetails findByEmail(String email);

}
