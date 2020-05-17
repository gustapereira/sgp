package br.com.sgp.repository;

import br.com.sgp.domain.PontoFacultativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoFacultativoRepository extends JpaRepository<PontoFacultativo, Long> {


}