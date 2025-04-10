package autoficha.api.model;

import autoficha.api.domain.classe.ClasseRecords;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "classes")
@Entity(name = "Classe")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Classe {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;
  private String nome;
  private Integer dados_vida;
  private Integer bonus_for;
  private Integer bonus_des;
  private Integer bonus_con;
  private Integer bonus_int;
  private Integer bonus_sab;
  private Integer bonus_car;
  private Integer percepcao;
  private Integer vontade;
  private Integer reflexos;
  private Integer fortitude;
  private String tipo_armas;
  private String tipo_armaduras;
  private String descricao;
  private String talentos_classe;

  public Classe(ClasseRecords dados) {
    this.nome = dados.nome();
    this.dados_vida = dados.dados_vida();
    this.bonus_for = dados.bonus_for();
    this.bonus_des = dados.bonus_des();
    this.bonus_con = dados.bonus_con();
    this.bonus_int = dados.bonus_int();
    this.bonus_sab = dados.bonus_sab();
    this.bonus_car = dados.bonus_car();
    this.percepcao = dados.percepcao();
    this.vontade = dados.vontade();
    this.reflexos = dados.reflexos();
    this.fortitude = dados.fortitude();
    this.tipo_armas = dados.tipo_armas();
    this.tipo_armaduras = dados.tipo_armaduras();
    this.descricao = dados.descricao();
    this.talentos_classe = dados.talentos_classe();
  }

}
