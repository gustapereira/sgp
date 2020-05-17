package br.com.sgp.repository;

import br.com.sgp.dto.TelefoneDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<TelefoneDTO, Long> {


}