package autoficha.api.domain.heranca;

public record HerancaRecord(
    Long id,
    Long raca_id,
    String nome,
    String descricao,
    String melhorias_atrib,
    String talentos_raca) {

}
