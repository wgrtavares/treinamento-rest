package br.com.cwi.treinamentorest.repository;

import br.com.cwi.treinamentorest.domain.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Long> {

    List<Ator> findByIdIn(List<Long> ids);
}
