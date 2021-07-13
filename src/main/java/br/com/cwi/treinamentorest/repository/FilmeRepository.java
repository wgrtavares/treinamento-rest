package br.com.cwi.treinamentorest.repository;

import br.com.cwi.treinamentorest.domain.Filme;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class FilmeRepository {

    static final List<Filme> filmes;

    static {
        filmes = Arrays.asList(
                new Filme("avatar"),
                new Filme("vingadores")
        );
    }

    public List<Filme> getFilmes() {
        return filmes;
    }
}
