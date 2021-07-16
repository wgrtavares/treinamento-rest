package br.com.cwi.treinamentorest.controller;

import br.com.cwi.treinamentorest.request.InserirAtorRequest;
import br.com.cwi.treinamentorest.response.ListarAtoresResponse;
import br.com.cwi.treinamentorest.service.InserirAtorService;
import br.com.cwi.treinamentorest.service.ListarAtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ator")
public class AtorController {

    @Autowired
    private ListarAtorService listarAtorService;

    @Autowired
    private InserirAtorService inserirAtorService;

    @GetMapping
    private ListarAtoresResponse listarAtores() {
        return listarAtorService.executar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void inserirAtor(@RequestBody final InserirAtorRequest request) {
        inserirAtorService.executar(request);
    }

}
