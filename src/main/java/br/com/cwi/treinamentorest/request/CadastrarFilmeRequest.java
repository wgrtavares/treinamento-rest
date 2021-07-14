package br.com.cwi.treinamentorest.request;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CadastrarFilmeRequest implements Serializable {

    private static final long serialVersionUID = 5080855787783936012L;
    private String titulo;

}
