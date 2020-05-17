package br.com.sgp.repository;

import br.com.sgp.domain.FolhaDePonto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolhaDePontoRepository extends JpaRepository<FolhaDePonto, Long> {


}