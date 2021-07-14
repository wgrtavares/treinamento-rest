package br.com.cwi.treinamentorest.controller;

import br.com.cwi.treinamentorest.request.CadastrarFilmeRequest;
import br.com.cwi.treinamentorest.request.ModificarFilmeRequest;
import br.com.cwi.treinamentorest.response.ListarFilmesResponse;
import br.com.cwi.treinamentorest.service.CadastrarFilmeService;
import br.com.cwi.treinamentorest.service.DeletarFilmeService;
import br.com.cwi.treinamentorest.service.ListarFilmesService;
import br.com.cwi.treinamentorest.service.ModificarFilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmesController {

    @Autowired
    private ListarFilmesService listarFilmesService;

    @Autowired
    private CadastrarFilmeService cadastrarFilmeService;

    @Autowired
    private ModificarFilmeService modificarFilmeService;

    @Autowired
    private DeletarFilmeService deletarFilmeService;

    @GetMapping("/")
    public ListarFilmesResponse getFilmes() {
        return listarFilmesService.listarFilmes();
    }

    @PostMapping("/")
    public void cadastrarFilme(@RequestBody final CadastrarFilmeRequest request) {
        cadastrarFilmeService.cadastrarFilme(request);
    }

    @PutMapping("/{id}")
    public void modificarFilme(@PathVariable Long id, @RequestBody final ModificarFilmeRequest request) {
        modificarFilmeService.modificarFilme(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable final Long id) {
        deletarFilmeService.deletarFilme(id);
    }
}
