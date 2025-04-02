package autoficha.api.domain.classe;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClasseRecords(
        String nome,
        @NotNull Integer dados_vida,
        Integer bonus_for,
        Integer bonus_des,
        Integer bonus_con,
        Integer bonus_int,
        Integer bonus_sab,
        Integer bonus_car,
        @NotNull Integer percepcao,
        @NotNull Integer vontade,
        @NotNull Integer reflexos,
        @NotNull Integer fortitude,
        @NotBlank String tipo_armas,
        @NotBlank String tipo_armaduras,
        @NotBlank String descricao,
        @NotBlank String talentos_classe

) {
}