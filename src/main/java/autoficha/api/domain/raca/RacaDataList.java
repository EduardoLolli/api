package autoficha.api.domain.raca;

import autoficha.api.model.Raca;

public record RacaDataList(
    Integer id,
    String nome,
    String tamanho,
    Integer velocidade_em_metros,
    String idiomas_base,
    String idioma_adicional,
    Boolean visao_escuro,
    String descricao) {

  public RacaDataList(Raca raca) {

    this(raca.getId(),
        raca.getNome(),
        raca.getTamanho(),
        raca.getVelocidade_em_metros(),
        raca.getIdiomas_base(),
        raca.getIdioma_adicional(),
        raca.getVisao_escuro(),
        raca.getDescricao());
  }
}
