package br.com.ponta.repository;

import br.com.ponta.dto.CentroCustoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroCustoRepository extends JpaRepository<CentroCustoDTO, Long> {


}