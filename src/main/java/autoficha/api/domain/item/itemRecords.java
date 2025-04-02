package autoficha.api.domain.item;

import jakarta.validation.constraints.NotBlank;

public record ItemRecords(
        Integer id,
        @NotBlank Integer tipo_item_id,
        @NotBlank String nome,
        @NotBlank Double valor_em_ouro,
        @NotBlank Double peso,
        String descricao,
        String propriedades) {

}
