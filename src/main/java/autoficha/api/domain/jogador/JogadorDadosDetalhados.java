package autoficha.api.domain.jogador;

public record JogadorDadosDetalhados(Integer id, String nome, String email, JogadorTipos tipo_jogador) {

  public JogadorDadosDetalhados(Jogador jogador) {
    this(
        jogador.getId(),
        jogador.getNome(),
        jogador.getEmail(),
        jogador.getTipo_jogador());
  }
};
