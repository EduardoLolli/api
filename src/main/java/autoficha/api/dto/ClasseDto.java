package autoficha.api.dto;

import autoficha.api.model.Classe;


public record ClasseDto(Integer id,
    String nome,
    Integer dados_vida,
    Integer bonus_for,
    Integer bonus_des,
    Integer bonus_con,
    Integer bonus_int,
    Integer bonus_sab,
    Integer bonus_car,
    Integer percepcao,
    Integer vontade,
    Integer reflexos,
    Integer fortitude,
    String tipo_armas,
    String tipo_armaduras,
    String descricao,
    String talentos_classe) {

  public ClasseDto(Classe classe) {
    this(classe.getId(),
        classe.getNome(),
        classe.getDados_vida(),
        classe.getBonus_for(),
        classe.getBonus_des(),
        classe.getBonus_con(),
        classe.getBonus_int(),
        classe.getBonus_sab(),
        classe.getBonus_car(),
        classe.getPercepcao(),
        classe.getVontade(),
        classe.getReflexos(),
        classe.getFortitude(),
        classe.getTipo_armas(),
        classe.getTipo_armaduras(),
        classe.getDescricao(),
        classe.getTalentos_classe());

  }

}