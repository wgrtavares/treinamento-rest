package br.com.cwi.treinamentorest.repository;

import br.com.cwi.treinamentorest.domain.Filme;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class FilmeRepository {

    static final List<Filme> filmes;

    static {
        filmes = new ArrayList<>( asList(
                new Filme(1L, "avatar"),
                new Filme(2L, "vingadores")
        ));
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void cadastrarFilme(Filme filme) {
        filme.setId(getFilmes().size() + 1L);
        filmes.add(filme);
    }
}
