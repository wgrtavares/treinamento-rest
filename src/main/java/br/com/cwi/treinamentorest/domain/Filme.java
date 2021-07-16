package br.com.cwi.treinamentorest.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "ID_DIRETOR")
    private Diretor diretor;

    @ManyToMany
    @JoinTable(
            name = "FILME_ATOR",
            joinColumns = @JoinColumn(name = "ID_FILME"),
            inverseJoinColumns = @JoinColumn(name = "ID_ATOR")
    )
    private List<Ator> atores;

}
