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

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CadastrarFilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private DiretorRepository diretorRepository;

    @Autowired
    private AtorRepository atorRepository;

    public void cadastrarFilme(CadastrarFilmeRequest request) {

        final Diretor diretor =
               diretorRepository.findById(request.getIdDiretor())
                       .orElseThrow(() -> new EntityNotFoundException("Diretor não encontrado."));

        final List<Ator> atores =
                atorRepository.findByIdIn(request.getIdsAtores());

        validarAtores(atores, request);

        filmeRepository.save( Filme.builder()
                .titulo(request.getTitulo())
                .diretor(diretor)
                .atores(atores)
                .build());
    }

    private void validarAtores(List<Ator> atores, CadastrarFilmeRequest request) {

        if (request.getIdsAtores().size() != atores.size()) {

            List<Long> idsEncontrados = atores.stream()
                    .map(Ator::getId)
                    .collect(Collectors.toList());

            List<Long> idsNaoEncontrados = request.getIdsAtores().stream()
                    .filter(idBuscado -> !idsEncontrados.contains(idBuscado))
                    .collect(Collectors.toList());

            throw new EntityNotFoundException(String.format(
                    "Ator(es) não encontrado(s). id=%s", idsNaoEncontrados));
        }
    }

}
