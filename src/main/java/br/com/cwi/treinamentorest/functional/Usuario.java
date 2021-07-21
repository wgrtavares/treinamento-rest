package br.com.cwi.treinamentorest.functional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Usuario {
    private String nome;
    private TipoUsuario tipo;
}
