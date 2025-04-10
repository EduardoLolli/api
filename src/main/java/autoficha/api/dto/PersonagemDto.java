package autoficha.api.dto;

import autoficha.api.model.Personagem;

public record PersonagemDto(Long id,
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
  public PersonagemDto(Personagem personagem) {
    this(
        personagem.getId(),
        personagem.getJogadorId().getId(),
        personagem.getHeranca_id(),
        personagem.getNome(),
        personagem.getNivel(),
        personagem.getExperiencia(),
        personagem.getRaca_id(),
        personagem.getClasse_id(),
        personagem.getBiografia_id(),
        personagem.getAlinhamento_eixo1(),
        personagem.getAlinhamento_eixo2(),
        personagem.getPontos_vida(),
        personagem.getPontos_vida_temp(),
        personagem.getHistoria(),
        personagem.getForca(),
        personagem.getDestreza(),
        personagem.getConstituicao(),
        personagem.getInteligencia(),
        personagem.getSabedoria(),
        personagem.getCarisma(),
        personagem.getCampanha_id(),
        personagem.getAtivo());

  }
};
