package br.com.sgp.repository;

import br.com.sgp.dto.SecaoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecaoRepository extends JpaRepository<SecaoDTO, Long> {


}