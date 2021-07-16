package br.com.cwi.treinamentorest.repository;

import br.com.cwi.treinamentorest.domain.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long> {
}
