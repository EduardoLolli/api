package autoficha.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import autoficha.api.domain.jogador.Jogador;
import autoficha.api.domain.jogador.JogadorDadosDetalhados;
import autoficha.api.domain.jogador.JogadorDataList;
import autoficha.api.domain.jogador.JogadorRecords;
import autoficha.api.domain.jogador.JogadorRepository;
import autoficha.api.domain.jogador.jogadorUpdateData;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("jogadores")
public class JogadorController {
  @Autowired
  private JogadorRepository repository;

  @GetMapping()
  public ResponseEntity<Page<JogadorDataList>> allPlayers(Pageable pagination) {
    Page<JogadorDataList> listaDeJogadores = repository.findAll(pagination).map(JogadorDataList::new);
    return ResponseEntity.ok(listaDeJogadores);
  }

  @GetMapping("/{id}")
  public ResponseEntity<JogadorDataList> findPlayerByID(@PathVariable Integer id) {
    JogadorDataList jogadorEncontrado = new JogadorDataList(repository.getReferenceById(id));
    return ResponseEntity.ok(jogadorEncontrado);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<JogadorDadosDetalhados> newPlayer(@RequestBody @Valid JogadorRecords dados,
      UriComponentsBuilder uibuilder) {
    var novoJogador = new Jogador(dados);
    repository.save(novoJogador);

    var uri = uibuilder.path("jogadores/{id}").buildAndExpand(novoJogador.getId()).toUri();
    return ResponseEntity.created(uri).body(new JogadorDadosDetalhados(novoJogador));
  }

  @PutMapping
  @Transactional
  public ResponseEntity<JogadorDadosDetalhados> updatePlayer(@RequestBody @Valid jogadorUpdateData dados) {
    var jogador = repository.getReferenceById(dados.id());
    jogador.updateValues(dados);
    return ResponseEntity.ok(new JogadorDadosDetalhados(jogador));
  }

}
