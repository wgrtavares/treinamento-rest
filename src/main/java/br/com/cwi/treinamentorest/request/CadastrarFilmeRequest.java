package br.com.cwi.treinamentorest.request;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
public class CadastrarFilmeRequest implements Serializable {

    private static final long serialVersionUID = 5080855787783936012L;
    private String titulo;
    private Long idDiretor;
    private List<Long> idsAtores;

}
