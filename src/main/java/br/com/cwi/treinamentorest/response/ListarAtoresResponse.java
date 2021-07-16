package br.com.cwi.treinamentorest.response;

import br.com.cwi.treinamentorest.domain.Ator;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@Builder
public class ListarAtoresResponse implements Serializable {
    private static final long serialVersionUID = -6071710184326324257L;
    private List<Ator> atores;
}
