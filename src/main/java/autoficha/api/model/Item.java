package autoficha.api.model;

import autoficha.api.domain.item.itemRecords;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "itens")
@Entity(name = "Item")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Integer id;
  private Integer tipo_item_id;
  private String nome;
  private Double valor_em_ouro;
  private Double peso;
  private String descricao;
  private String propriedades;

  public Item(itemRecords dados) {
    this.id = dados.id();
    this.tipo_item_id = dados.tipo_item_id();
    this.nome = dados.nome();
    this.valor_em_ouro = dados.valor_em_ouro();
    this.peso = dados.peso();
    this.descricao = dados.descricao();
    this.propriedades = dados.propriedades();
  }

}
