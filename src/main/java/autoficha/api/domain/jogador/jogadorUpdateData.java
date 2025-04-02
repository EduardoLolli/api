package autoficha.api.domain.jogador;

import autoficha.api.model.JogadorTipos;
import jakarta.validation.constraints.NotNull;

public record JogadorUpdateData(
    @NotNull Integer id,
    String nome,
    String senha,
    JogadorTipos tipo_jogador) {

}
