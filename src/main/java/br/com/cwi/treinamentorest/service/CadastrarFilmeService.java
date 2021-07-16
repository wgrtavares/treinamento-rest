package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.domain.Diretor;
import br.com.cwi.treinamentorest.domain.Filme;
import br.com.cwi.treinamentorest.repository.DiretorRepository;
import br.com.cwi.treinamentorest.repository.FilmeRepository;
import br.com.cwi.treinamentorest.request.CadastrarFilmeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastrarFilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private DiretorRepository diretorRepository;

    public void cadastrarFilme(CadastrarFilmeRequest request) {
        final Optional<Diretor> diretor = diretorRepository.findById(request.getIdDiretor());
        filmeRepository.save( Filme.builder()
                .titulo(request.getTitulo())
                .diretor(diretor.orElse(null))
                .build());
    }
}
