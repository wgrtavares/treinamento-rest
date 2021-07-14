package br.com.cwi.treinamentorest.repository;

import br.com.cwi.treinamentorest.domain.Filme;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FilmeRepository {

    static final Map<Long, Filme> filmes = new HashMap<>();

    static {
        filmes.put(1L, new Filme(1L, "Avatar"));
        filmes.put(2L, new Filme(2L, "Vingadores"));
    }

    public List<Filme> getFilmes() {
        return new ArrayList<>(filmes.values());
    }

    public void cadastrarFilme(Filme filme) {
        filme.setId(getFilmes().size() + 1L);
        filmes.put(filme.getId(), filme);
    }

    public void modificarFilme(Long id, String titulo) {
        if(!filmes.containsKey(id))
            return;

        final Filme filme = filmes.get(id);
        filme.setTitulo(titulo);
    }
}
