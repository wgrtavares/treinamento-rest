package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.domain.Diretor;
import br.com.cwi.treinamentorest.domain.Filme;
import br.com.cwi.treinamentorest.repository.DiretorRepository;
import br.com.cwi.treinamentorest.repository.FilmeRepository;
import br.com.cwi.treinamentorest.request.ModificarFilmeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModificarFilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private DiretorRepository diretorRepository;

    public void modificarFilme(Long id, ModificarFilmeRequest request) {
        Optional<Diretor> diretor = diretorRepository.findById(request.getIdDiretor());
        filmeRepository.save(
                Filme.builder()
                        .id(id)
                        .titulo(request.getTitulo())
                        .diretor(diretor.orElse(null))
                        .build());
    }
}
