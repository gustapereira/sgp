package br.com.sgp.repository;

import br.com.sgp.dto.UFDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UFRepository extends JpaRepository<UFDTO, Long> {


}