package autoficha.api.domain.jogador;

import jakarta.validation.constraints.NotNull;

public record jogadorUpdateData(
    @NotNull Integer id,
    String nome,
    String senha,
    JogadorTipos tipo_jogador) {

}
