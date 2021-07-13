package br.com.cwi.treinamentorest.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Filme implements Serializable {

    private static final long serialVersionUID = 2056417064101774281L;

    private String titulo;

}