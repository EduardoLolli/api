package autoficha.api.domain.personagem;


public record PersonagemRecords(
                Long id,
                Long jogadorId,
                Long heranca_id,
                String nome,
                Integer nivel,
                Integer experiencia,
                Long raca_id,
                Long classe_id,
                Long biografia_id,
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
                Long campanha_id,
                Boolean ativo) {

}
