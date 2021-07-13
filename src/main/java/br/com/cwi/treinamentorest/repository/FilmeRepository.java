package br.com.cwi.treinamentorest.repository;

import br.com.cwi.treinamentorest.domain.Filme;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class FilmeRepository {

    static final List<Filme> filmes;

    static {
        filmes = new ArrayList<>( asList(
                new Filme("avatar"),
                new Filme("vingadores")
        ));
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void cadastrarFilme(Filme filme) {
        filmes.add(filme);
    }
}
