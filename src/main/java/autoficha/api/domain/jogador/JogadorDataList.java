package autoficha.api.domain.jogador;

import autoficha.api.model.Jogador;
import autoficha.api.model.JogadorTipos;

public record JogadorDataList(
    Long id,
    String nome,
    String email,
    String senha,
    JogadorTipos tipo_jogador) {

  public JogadorDataList(Jogador jogador) {
    this(
        jogador.getId(),
        jogador.getNome(),
        jogador.getEmail(),
        jogador.getSenha(),
        jogador.getTipo_jogador());
  }

}
