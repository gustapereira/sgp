package br.com.sgp.repository;

import br.com.sgp.dto.AfastamentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfastamentoRepository extends JpaRepository<AfastamentoDTO, Long> {

}