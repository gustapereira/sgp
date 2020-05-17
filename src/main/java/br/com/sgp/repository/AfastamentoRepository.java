package br.com.sgp.repository;

import br.com.sgp.domain.Afastamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfastamentoRepository extends JpaRepository<Afastamento, Long> {

}