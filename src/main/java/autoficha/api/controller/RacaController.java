package autoficha.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import autoficha.api.domain.raca.RacaDataList;
import autoficha.api.domain.raca.RacaRecords;
import autoficha.api.dto.RacaDto;
import autoficha.api.model.Raca;
import autoficha.api.repository.RacaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("racas")
public class RacaController {
  @Autowired
  private RacaRepository repository;

  @GetMapping()
  public ResponseEntity<Page<RacaDataList>> allRacas(Pageable pagination) {
    Page<RacaDataList> racaLista = repository.findAll(pagination).map(RacaDataList::new);
    return ResponseEntity.ok(racaLista);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<RacaDto> newRaca(@RequestBody @Valid RacaRecords dados,
      UriComponentsBuilder uibuilder) {
    var newRace = new Raca(dados);
    repository.save(newRace);

    var uri = uibuilder.path("racas/{id}").buildAndExpand(newRace.getId()).toUri();
    return ResponseEntity.created(uri).body(new RacaDto(newRace));
  }

}
