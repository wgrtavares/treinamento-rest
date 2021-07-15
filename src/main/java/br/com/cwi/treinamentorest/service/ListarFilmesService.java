package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.converter.FilmeConverter;
import br.com.cwi.treinamentorest.domain.Filme;
import br.com.cwi.treinamentorest.entity.FilmeEntity;
import br.com.cwi.treinamentorest.repository.FilmeEntityRepository;
import br.com.cwi.treinamentorest.repository.FilmeRepository;
import br.com.cwi.treinamentorest.response.ListarFilmesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarFilmesService {

    @Autowired
//    private FilmeRepository repository;
    private FilmeEntityRepository repository;

    public ListarFilmesResponse listarFilmes() {
        return
                ListarFilmesResponse.builder()
//                        .filmes(repository.getFilmes())
                        .filmes(FilmeConverter.entityToDomain(repository.findAll()))
                        .build();
    }
}
