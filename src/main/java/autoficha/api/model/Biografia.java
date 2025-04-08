package autoficha.api.model;

import autoficha.api.domain.biografia.BiografiaRecord;
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

@Table(name = "biografias")
@Entity(name = "Biografia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Biografia {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String descricao;
  private String melhorias_atrib;

  public Biografia(BiografiaRecord biografia) {
    this.nome = biografia.nome();
    this.descricao = biografia.descricao();
    this.melhorias_atrib = biografia.melhorias_atrib();
  }
}
