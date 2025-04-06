package autoficha.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import autoficha.api.controller.ClasseController;
import autoficha.api.domain.personagem.PersonagemDataList;
import autoficha.api.model.Personagem;
import autoficha.api.repository.PersonagemRepository;

@Service
public class PersonagemService {

  @Autowired
  private PersonagemRepository personagemRepository;
  @Autowired
  private ClasseController controllerClass;

  public Integer calculaVida(Integer classeId, Integer nivelPersonagem) {
    var classeReq = controllerClass.findClasseByID(classeId);
    if (nivelPersonagem == null) {
      nivelPersonagem = 1;
    }
    Integer valorVida = classeReq.getBody().dados_vida() * nivelPersonagem;
    return valorVida;
  }

}
