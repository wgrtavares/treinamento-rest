package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.entity.FilmeEntity;
import br.com.cwi.treinamentorest.repository.FilmeEntityRepository;
import br.com.cwi.treinamentorest.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarFilmeService {

    @Autowired
//    FilmeRepository repository;
    FilmeEntityRepository repository;

    public void deletarFilme(Long id) {
//        repository.deletar(id);
        repository.deleteById(id);
    }
}
