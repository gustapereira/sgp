package br.com.sgp.repository;

import br.com.sgp.dto.RegistroEletronicoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroEletronicoRepository extends JpaRepository<RegistroEletronicoDTO, Long> {


}