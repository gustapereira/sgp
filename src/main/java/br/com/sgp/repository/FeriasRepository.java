package br.com.sgp.repository;

import br.com.sgp.dto.EnderecoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeriasRepository extends JpaRepository<EnderecoDTO, Long> {


}