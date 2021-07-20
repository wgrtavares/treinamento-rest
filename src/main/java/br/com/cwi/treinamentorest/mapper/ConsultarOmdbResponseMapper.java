package br.com.cwi.treinamentorest.mapper;

import br.com.cwi.treinamentorest.domain.Ator;
import br.com.cwi.treinamentorest.response.ConsultarOmdbApiResponse;
import br.com.cwi.treinamentorest.response.ConsultarOmdbResponse;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class ConsultarOmdbResponseMapper implements Function<ConsultarOmdbApiResponse, ConsultarOmdbResponse> {

    @Override
    public ConsultarOmdbResponse apply(ConsultarOmdbApiResponse consultarOmdbApiResponse) {
        if (isNull(consultarOmdbApiResponse)) {
            return null;
        }

        return ConsultarOmdbResponse.builder()
                .atores(Arrays.stream(consultarOmdbApiResponse.getAtores().split(", *"))
                        .map(nome -> Ator.builder().nome(nome).build())
                        .collect(Collectors.toList()))
                .ano(consultarOmdbApiResponse.getAno())
                .dataLancamento(consultarOmdbApiResponse.getDataLancamento())
                .duracao(consultarOmdbApiResponse.getDataLancamento())
                .genero(consultarOmdbApiResponse.getGenero())
                .titulo(consultarOmdbApiResponse.getTitulo())
                .build();
    }
}
