package br.com.sgp.repository;

import br.com.sgp.domain.CBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CBORepository extends JpaRepository<CBO, Long> {

}