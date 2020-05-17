package br.com.sgp.repository;

import br.com.sgp.dto.NacionalidadeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NacionalidadeRepository extends JpaRepository<NacionalidadeDTO, Long> {


}