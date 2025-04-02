package autoficha.api.domain.raca;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RacaRecords(
        Integer id,
        @NotBlank String nome,
        @NotNull String tamanho,
        @NotNull Integer velocidade_em_metros,
        @NotBlank String idiomas_base,
        @NotBlank String idioma_adicional,
        @NotNull Boolean visao_escuro,
        @NotBlank String descricao) {
}
