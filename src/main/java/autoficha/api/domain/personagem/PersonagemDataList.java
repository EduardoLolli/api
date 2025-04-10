package autoficha.api.domain.personagem;

import autoficha.api.model.Personagem;

public record PersonagemDataList(
    Long id,
    Long jogadorId,
    Long herancaId,
    String nome,
    Integer nivel,
    Integer experiencia,
    Long racaId,
    Long classeId,
    Long biografiaId,
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
    Long campanhaId,
    Boolean ativo) {

  public PersonagemDataList(Personagem personagem) {
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

}