package br.com.sgp.repository;

import br.com.sgp.dto.DepartamentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoDTO, Long> {


}