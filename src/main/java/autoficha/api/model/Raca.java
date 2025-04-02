package autoficha.api.model;

import autoficha.api.domain.raca.RacaRecords;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "racas")
@Entity(name = "Raca")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Raca {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String tamanho;
  private Integer velocidade_em_metros;
  private String idiomas_base;
  private String idioma_adicional;
  private Boolean visao_escuro;
  private String descricao;

  public Raca(RacaRecords dados) {
    this.id = dados.id();
    this.nome = dados.nome();
    this.tamanho = dados.tamanho();
    this.velocidade_em_metros = dados.velocidade_em_metros();
    this.idiomas_base = dados.idiomas_base();
    this.idioma_adicional = dados.idioma_adicional();
    this.visao_escuro = dados.visao_escuro();
    this.descricao = dados.descricao();
  }
}
