package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.repository.FilmeRepository;
import br.com.cwi.treinamentorest.response.ListarFilmesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListarFilmesService {

    @Autowired
    private FilmeRepository repositorio;

    public ListarFilmesResponse listarFilmes() {
        return
                ListarFilmesResponse.builder()
                        .filmes(repositorio.findAll())
                        .build();
    }
}
