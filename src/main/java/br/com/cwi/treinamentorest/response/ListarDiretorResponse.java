package br.com.cwi.treinamentorest.response;

import br.com.cwi.treinamentorest.domain.Diretor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@Builder
public class ListarDiretorResponse implements Serializable {
    private static final long serialVersionUID = 6776617067312998967L;
    private List<Diretor> diretores;
}
