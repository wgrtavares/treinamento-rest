package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.repository.FilmeRepository;
import br.com.cwi.treinamentorest.request.ModificarFilmeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModificarFilmeService {

    @Autowired
    private FilmeRepository repository;

    public void modificarFilme(Long id, ModificarFilmeRequest request) {
        repository.modificar(id, request.getTitulo());
    }
}
