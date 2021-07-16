package br.com.cwi.treinamentorest.controller;

import br.com.cwi.treinamentorest.request.AdicionarDiretorRequest;
import br.com.cwi.treinamentorest.response.ListarDiretorResponse;
import br.com.cwi.treinamentorest.service.AdicionarDiretorService;
import br.com.cwi.treinamentorest.service.ListarDiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/diretor")
public class DiretorController {

    @Autowired
    private AdicionarDiretorService adicionarDiretorService;

    @Autowired
    private ListarDiretorService listarDiretorService;

    @GetMapping
    public ListarDiretorResponse listar() {
        return listarDiretorService.listar();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void adicionar(@RequestBody final AdicionarDiretorRequest request) {
        adicionarDiretorService.executar(request);
    }
}
