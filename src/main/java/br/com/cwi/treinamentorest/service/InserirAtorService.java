package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.domain.Ator;
import br.com.cwi.treinamentorest.repository.AtorRepository;
import br.com.cwi.treinamentorest.request.InserirAtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InserirAtorService {

    @Autowired
    private AtorRepository atorRepository;

    public void executar(InserirAtorRequest request) {
        atorRepository.save(Ator.builder()
                .nome(request.getNome())
                .build());
    }
}
