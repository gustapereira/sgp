package br.com.sgp.repository;

import br.com.sgp.dto.HierarquiaExternaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HierarquiaExternaRepository extends JpaRepository<HierarquiaExternaDTO, Long> {


}