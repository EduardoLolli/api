package autoficha.api.dto;

import autoficha.api.model.Jogador;
import autoficha.api.model.JogadorTipos;

public record JogadorDto(Integer id, String nome, String email, JogadorTipos tipo_jogador) {

  public JogadorDto(Jogador jogador) {
    this(
        jogador.getId(),
        jogador.getNome(),
        jogador.getEmail(),
        jogador.getTipo_jogador());
  }
};


