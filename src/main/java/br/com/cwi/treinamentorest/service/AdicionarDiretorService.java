package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.domain.Diretor;
import br.com.cwi.treinamentorest.repository.DiretorRepository;
import br.com.cwi.treinamentorest.request.AdicionarDiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionarDiretorService {

    @Autowired
    private DiretorRepository repository;

    public void executar(AdicionarDiretorRequest request) {
        repository.save(Diretor.builder()
                .nome(request.getNome())
                .build());
    }
}
