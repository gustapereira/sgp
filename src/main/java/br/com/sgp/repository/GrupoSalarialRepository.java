package br.com.sgp.repository;

import br.com.sgp.domain.GrupoSalarial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoSalarialRepository extends JpaRepository<GrupoSalarial, Long> {

}