package br.com.cwi.treinamentorest.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ATOR")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Ator implements Serializable {

    private static final long serialVersionUID = 4833096022795952509L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;
}
