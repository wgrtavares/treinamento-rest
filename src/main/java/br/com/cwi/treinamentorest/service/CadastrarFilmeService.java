package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.domain.Filme;
import br.com.cwi.treinamentorest.repository.FilmeRepository;
import br.com.cwi.treinamentorest.request.CadastrarFilmeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarFilmeService {

    @Autowired
    private FilmeRepository repository;

    public void cadastrarFilme(CadastrarFilmeRequest request) {
        repository.cadastrar(
                Filme.builder()
                .titulo(request.getTitulo())
                .build());
    }
}
