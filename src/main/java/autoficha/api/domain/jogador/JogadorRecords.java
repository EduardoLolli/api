package autoficha.api.domain.jogador;

import java.util.List;

import autoficha.api.model.JogadorTipos;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JogadorRecords(

        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotNull JogadorTipos tipo_jogador,
        @NotBlank String senha) {

}
