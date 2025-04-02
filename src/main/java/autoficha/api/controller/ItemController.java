package autoficha.api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import autoficha.api.domain.item.ItemDataList;
import autoficha.api.repository.ItemRepository;

@RestController
@RequestMapping("itens")
public class ItemController {
  @Autowired
  private ItemRepository repository;

  @GetMapping
  public List<ItemDataList> allItens() {
    return repository.findAll().stream().map(ItemDataList::new).toList();
  }

  @RequestMapping("fil")
  @GetMapping
  public Page<ItemDataList> filteredItens(Pageable pagination) {
    return repository.findAll(pagination).map(ItemDataList::new);
  }

}
