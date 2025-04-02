package autoficha.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import autoficha.api.domain.personagem.PersonagemDataList;
import autoficha.api.repository.PersonagemRepository;

@RestController
@RequestMapping("personagens")
public class PersonagemController {
  @Autowired
  private PersonagemRepository repository;

  @GetMapping()
  public ResponseEntity<Page<PersonagemDataList>> allCharacters(Pageable pagination) {
    Page<PersonagemDataList> listaDePersonagens = repository.findAll(pagination).map(PersonagemDataList::new);
    return ResponseEntity.ok(listaDePersonagens);
  }

}