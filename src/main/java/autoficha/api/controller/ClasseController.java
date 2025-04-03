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

import autoficha.api.domain.classe.ClasseDataList;
import autoficha.api.domain.classe.ClasseRecords;
import autoficha.api.dto.ClasseDto;
import autoficha.api.model.Classe;
import autoficha.api.repository.ClasseRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("classes")
public class ClasseController {
  @Autowired
  private ClasseRepository repository;

  @GetMapping()
  public ResponseEntity<Page<ClasseDataList>> allClasses(Pageable pagination) {
    Page<ClasseDataList> classeLista = repository.findAll(pagination).map(ClasseDataList::new);
    return ResponseEntity.ok(classeLista);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<ClasseDto> newClasse(@RequestBody @Valid ClasseRecords dados,
      UriComponentsBuilder uibuilder) {
    var newclasse = new Classe(dados);
    repository.save(newclasse);

    var uri = uibuilder.path("classe/{id}").buildAndExpand(newclasse.getId()).toUri();
    return ResponseEntity.created(uri).body(new ClasseDto(newclasse));
  }

}
