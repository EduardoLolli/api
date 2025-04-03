package autoficha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import autoficha.api.model.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Integer> {
}
