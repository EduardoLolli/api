package autoficha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import autoficha.api.model.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {

}
