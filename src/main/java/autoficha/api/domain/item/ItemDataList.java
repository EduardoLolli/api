package autoficha.api.domain.item;

import autoficha.api.model.Item;

public record ItemDataList(
    Integer id,
    Integer tipo_item_id,
    String nome,
    Double valor_em_ouro,
    Double peso,
    String descricao,
    String propriedades) {

  public ItemDataList(Item item) {
    this(
        item.getId(),
        item.getTipo_item_id(),
        item.getNome(),
        item.getValor_em_ouro(),
        item.getPeso(),
        item.getDescricao(),
        item.getPropriedades());
  }

}