package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.repository.DiretorRepository;
import br.com.cwi.treinamentorest.response.ListarDiretorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListarDiretorService {

    @Autowired
    private DiretorRepository repository;

    public ListarDiretorResponse listar() {
        return ListarDiretorResponse.builder()
                .diretores(repository.findAll())
                .build();
    }
}
