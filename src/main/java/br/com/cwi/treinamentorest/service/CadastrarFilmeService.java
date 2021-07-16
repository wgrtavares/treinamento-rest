package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.domain.Ator;
import br.com.cwi.treinamentorest.domain.Diretor;
import br.com.cwi.treinamentorest.domain.Filme;
import br.com.cwi.treinamentorest.repository.AtorRepository;
import br.com.cwi.treinamentorest.repository.DiretorRepository;
import br.com.cwi.treinamentorest.repository.FilmeRepository;
import br.com.cwi.treinamentorest.request.CadastrarFilmeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastrarFilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private DiretorRepository diretorRepository;

    @Autowired
    private AtorRepository atorRepository;

    public void cadastrarFilme(CadastrarFilmeRequest request) {
        final Optional<Diretor> diretor = diretorRepository.findById(request.getIdDiretor());
        final List<Ator> atores = atorRepository.findByIdIn(request.getIdsAtores());
        filmeRepository.save( Filme.builder()
                .titulo(request.getTitulo())
                .diretor(diretor.orElse(null))
                .atores(atores)
                .build());
    }
}
