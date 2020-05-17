package br.com.sgp.repository;

import br.com.sgp.domain.HierarquiaExterna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HierarquiaExternaRepository extends JpaRepository<HierarquiaExterna, Long> {


}