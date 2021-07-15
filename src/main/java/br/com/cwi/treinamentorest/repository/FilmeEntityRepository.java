package br.com.cwi.treinamentorest.repository;

import br.com.cwi.treinamentorest.entity.FilmeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeEntityRepository extends JpaRepository<FilmeEntity, Long> {

}
