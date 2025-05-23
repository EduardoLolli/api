package autoficha.api.domain.jogador;

public record JogadorDataList(
    Integer id,
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
