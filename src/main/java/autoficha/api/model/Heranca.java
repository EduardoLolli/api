package autoficha.api.model;

import autoficha.api.domain.heranca.HerancaRecord;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "herancas")
@Entity(name = "Heranca")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Heranca {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long raca_id;
  private String nome;
  private String descricao;
  private String melhorias_atrib;
  private String talentos_raca;

  public Heranca(HerancaRecord dados) {
    this.id = dados.id();
    this.raca_id = dados.raca_id();
    this.nome = dados.nome();
    this.descricao = dados.descricao();
    this.melhorias_atrib = dados.melhorias_atrib();
    this.talentos_raca = dados.talentos_raca();
  }
}
