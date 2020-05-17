package br.com.sgp.repository;

import br.com.sgp.dto.CBODTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CBORepository extends JpaRepository<CBODTO, Long> {

}