package br.com.cwi.treinamentorest.response;

import br.com.cwi.treinamentorest.domain.Filme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ListarFilmesResponse implements Serializable {

    private static final long serialVersionUID = -6238464543476836117L;

    private final List<Filme> filmes;

}
