package br.com.cwi.treinamentorest.controller;

import br.com.cwi.treinamentorest.controller.api.FilmesControllerAPI;
import br.com.cwi.treinamentorest.request.CadastrarFilmeRequest;
import br.com.cwi.treinamentorest.request.ModificarFilmeRequest;
import br.com.cwi.treinamentorest.response.ConsultarOmdbResponse;
import br.com.cwi.treinamentorest.response.ListarFilmesResponse;
import br.com.cwi.treinamentorest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/filme")
public class FilmesController implements FilmesControllerAPI {

    @Autowired
    private ListarFilmesService listarFilmesService;

    @Autowired
    private CadastrarFilmeService cadastrarFilmeService;

    @Autowired
    private ModificarFilmeService modificarFilmeService;

    @Autowired
    private DeletarFilmeService deletarFilmeService;

    @Autowired
    private ConsultarOmdbApiService consultarOmdbApiService;

    @GetMapping("/")
    public ListarFilmesResponse listarFilmes() {
        return listarFilmesService.listarFilmes();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarFilme(@RequestBody final CadastrarFilmeRequest request) {
        try {

            cadastrarFilmeService.cadastrarFilme(request);

        } catch (EntityNotFoundException enfe) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, enfe.getMessage(), enfe.getCause());
        }
    }

    @PutMapping("/{id}")
    public void modificarFilme(@PathVariable Long id, @RequestBody final ModificarFilmeRequest request) {
        modificarFilmeService.modificarFilme(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable final Long id) {
        deletarFilmeService.deletarFilme(id);
    }

    @GetMapping("/titulo/{titulo}")
    public ConsultarOmdbResponse consultarFilmePorTitulo(@PathVariable final String titulo) {
        return consultarOmdbApiService.consultarPorTitulo(titulo);
    }
}
