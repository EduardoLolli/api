package autoficha.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import autoficha.api.domain.personagem.PersonagemDataList;
import autoficha.api.domain.personagem.PersonagemRecords;
import autoficha.api.dto.PersonagemDto;
import autoficha.api.model.Personagem;
import autoficha.api.repository.PersonagemRepository;
import autoficha.api.service.PersonagemService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("personagens")
public class PersonagemController {
  @Autowired
  private PersonagemRepository repository;

  @Autowired
  PersonagemService persoService;

  @GetMapping()
  public ResponseEntity<Page<PersonagemDataList>> allCharacters(Pageable pagination) {
    Page<PersonagemDataList> listaDePersonagens = repository.findAll(pagination).map(PersonagemDataList::new);
    return ResponseEntity.ok(listaDePersonagens);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PersonagemDataList> personagemPeloId(@PathVariable Integer id) {
    PersonagemDataList personagem = new PersonagemDataList(repository.getReferenceById(id));
    return ResponseEntity.ok(personagem);

  }

 

  @PostMapping
  @Transactional
  public ResponseEntity<PersonagemDto> newCharacter(@RequestBody @Valid PersonagemRecords dados,
      UriComponentsBuilder uibuilder) {
    var novoPersonagem = new Personagem(dados);
    Integer vidaTotal = persoService.calculaVida(novoPersonagem.getClasse_id(), novoPersonagem.getNivel());
    novoPersonagem.setPontos_vida(vidaTotal);
    repository.save(novoPersonagem);
    var uri = uibuilder.path("jogadores/{id}").buildAndExpand(novoPersonagem.getId()).toUri();
    return ResponseEntity.created(uri).body(new PersonagemDto(novoPersonagem));
  }

}