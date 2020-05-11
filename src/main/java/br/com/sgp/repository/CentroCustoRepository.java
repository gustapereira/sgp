package br.com.sgp.repository;

import br.com.sgp.dto.CentroCustoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroCustoRepository extends JpaRepository<CentroCustoDTO, Long> {


}