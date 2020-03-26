package br.com.ponta.repository;

import br.com.ponta.domain.FolhaDePonto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolhaDePontoRepository extends JpaRepository<FolhaDePonto, Long> {


}