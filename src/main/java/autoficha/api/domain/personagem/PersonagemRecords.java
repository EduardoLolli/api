package autoficha.api.domain.personagem;

public record PersonagemRecords(
    Integer id,
    Integer jogador_id,
    Integer heranca_id,
    String nome,
    Integer nivel,
    Integer experiencia,
    Integer raca_id,
    Integer classe_id,
    Integer biografia_id,
    String alinhamento_eixo1,
    String alinhamento_eixo2,
    Integer pontos_vida,
    Integer pontos_vida_temp,
    String historia,
    Integer forca,
    Integer destreza,
    Integer constituicao,
    Integer inteligencia,
    Integer sabedoria,
    Integer carisma,
    Integer campanha_id,
    Boolean ativo) {

}
