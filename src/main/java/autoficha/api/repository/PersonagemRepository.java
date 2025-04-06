package autoficha.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import autoficha.api.domain.personagem.PersonagemDataList;
import autoficha.api.model.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {

}
