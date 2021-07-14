package br.com.cwi.treinamentorest.controller;

import br.com.cwi.treinamentorest.request.CadastrarFilmeRequest;
import br.com.cwi.treinamentorest.response.ListarFilmesResponse;
import br.com.cwi.treinamentorest.service.CadastrarFilmeService;
import br.com.cwi.treinamentorest.service.ListarFilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmesController {

    @Autowired
    private ListarFilmesService listarFilmesService;

    @Autowired
    private CadastrarFilmeService cadastrarFilmeService;

    @GetMapping("/")
    public ListarFilmesResponse getFilmes() {
        return listarFilmesService.listarFilmes();
    }

    @PostMapping("/")
    public void cadastrarFilme(@RequestBody final CadastrarFilmeRequest request) {
        cadastrarFilmeService.cadastrarFilme(request);
    }
}
