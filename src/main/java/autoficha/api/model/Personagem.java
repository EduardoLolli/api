package autoficha.api.model;

import autoficha.api.domain.personagem.PersonagemRecords;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "personagens")
@Entity(name = "Personagem")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Personagem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Integer id;
  private Integer jogador_id;
  private Integer heranca_id;
  private String nome;
  private Integer nivel;
  private Integer experiencia;
  private Integer raca_id;
  private Integer classe_id;
  private Integer biografia_id;
  private String alinhamento_eixo1;
  private String alinhamento_eixo2;
  private Integer pontos_vida;
  private Integer pontos_vida_temp;
  private String historia;
  private Integer forca;
  private Integer destreza;
  private Integer constituicao;
  private Integer inteligencia;
  private Integer sabedoria;
  private Integer carisma;
  private Integer campanha_id;
  private Boolean ativo;

  public Personagem(PersonagemRecords dados) {
    this.jogador_id = dados.jogador_id();
    this.heranca_id = dados.heranca_id();
    this.nome = dados.nome();
    this.nivel = dados.nivel();
    this.experiencia = dados.experiencia();
    this.raca_id = dados.raca_id();
    this.classe_id = dados.classe_id();
    this.biografia_id = dados.biografia_id();
    this.alinhamento_eixo1 = dados.alinhamento_eixo1();
    this.alinhamento_eixo2 = dados.alinhamento_eixo2();
    this.pontos_vida = dados.pontos_vida();
    this.pontos_vida_temp = dados.pontos_vida_temp();
    this.historia = dados.historia();
    this.forca = dados.forca();
    this.destreza = dados.destreza();
    this.constituicao = dados.constituicao();
    this.inteligencia = dados.inteligencia();
    this.sabedoria = dados.sabedoria();
    this.carisma = dados.carisma();
    this.campanha_id = dados.campanha_id();
    this.ativo = dados.ativo();

  }

}
