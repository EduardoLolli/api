package autoficha.api.dto;

import autoficha.api.model.Raca;

public record RacaDadosDetalhados(
    Integer id,
    String nome,
    String tamanho,
    Integer velocidade_em_metros,
    String idiomas_base,
    String idioma_adicional,
    Boolean visao_escuro,
    String descricao) {

  public RacaDadosDetalhados(Raca raca) {
    this(
        raca.getId(),
        raca.getNome(),
        raca.getTamanho(),
        raca.getVelocidade_em_metros(),
        raca.getIdiomas_base(),
        raca.getIdioma_adicional(),
        raca.getVisao_escuro(),
        raca.getDescricao());
  }

}
