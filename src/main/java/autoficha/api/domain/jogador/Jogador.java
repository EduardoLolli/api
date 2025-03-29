package autoficha.api.domain.jogador;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "jogadores")
@Entity(name = "Jogador")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Jogador {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String email;
  private String senha;

  @Enumerated(EnumType.STRING)
  private JogadorTipos tipo_jogador;

  public Jogador(JogadorRecords dados) {
    this.nome = dados.nome();
    this.email = dados.email();
    this.senha = dados.senha();
    this.tipo_jogador = dados.tipo_jogador();
  }

  public void updateValues(jogadorUpdateData dados) {
    try {
      if (dados.nome() != null) {
        this.nome = dados.nome();
      }
      if (dados.senha() != null) {
        this.senha = dados.senha();
      }
      if (dados.tipo_jogador() != null) {
        this.tipo_jogador = dados.tipo_jogador();
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

}
