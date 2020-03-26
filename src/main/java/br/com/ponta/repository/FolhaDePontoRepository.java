package br.com.ponta.repository;

import br.com.ponta.dto.FolhaDePontoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolhaDePontoRepository extends JpaRepository<FolhaDePontoDTO, Long> {


}