package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.repository.AtorRepository;
import br.com.cwi.treinamentorest.response.ListarAtoresResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListarAtorService {

    @Autowired
    private AtorRepository atorRepository;

    public ListarAtoresResponse executar() {
        return ListarAtoresResponse.builder()
                .atores(atorRepository.findAll())
                .build();
    }
}
