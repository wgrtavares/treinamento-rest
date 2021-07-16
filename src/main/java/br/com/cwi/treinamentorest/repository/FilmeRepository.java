package br.com.cwi.treinamentorest.repository;

import br.com.cwi.treinamentorest.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    /**
     * Pesquisando filmes por título.
     * @param titulo
     * @return
     */
    Filme findByTitulo(String titulo);

    /**
     * Pequisando filmes por id do Diretor.
     * @param id
     * @return
     */
    List<Filme> findByDiretorId(Long id);

    /**
     * Contando filmes por id do Diretor.
     * @param id
     * @return
     */
    Long countByDiretorId(Long id);

    /**
     * Verifica se existe filme com o diretor.id.
     * @param id
     * @return
     */
    Boolean existsByDiretorId(Long id);
}
