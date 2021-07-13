package br.com.cwi.treinamentorest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmesController {

    @GetMapping("/{filme}")
    public String getFilmes(@PathVariable final String filme) {
        return filme;
    }
}
