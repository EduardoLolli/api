package autoficha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import autoficha.api.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

  UserDetails findByEmail(String email);

}
