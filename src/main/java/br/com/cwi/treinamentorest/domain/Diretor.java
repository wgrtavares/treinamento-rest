package br.com.cwi.treinamentorest.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DIRETOR")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Diretor implements Serializable {

    private static final long serialVersionUID = -3666751714197413442L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

}
