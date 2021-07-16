package br.com.cwi.treinamentorest.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FILME")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Filme implements Serializable {

    private static final long serialVersionUID = 2056417064101774281L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

}
