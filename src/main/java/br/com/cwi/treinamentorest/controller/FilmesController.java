package br.com.cwi.treinamentorest.controller;

import br.com.cwi.treinamentorest.response.ListarFilmesResponse;
import br.com.cwi.treinamentorest.service.ListarFilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmesController {

    @Autowired
    private ListarFilmesService listarFilmesService;

    @GetMapping("/listar-filmes")
    public ListarFilmesResponse getFilmes() {
        return listarFilmesService.listarFilmes();
    }
}
