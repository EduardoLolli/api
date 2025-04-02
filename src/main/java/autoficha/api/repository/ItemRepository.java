package autoficha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import autoficha.api.model.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{

}
