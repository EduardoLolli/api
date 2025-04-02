package autoficha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import autoficha.api.model.Raca;

public interface RacaRepository extends JpaRepository<Raca, Integer> {
}
