package br.com.sgp.repository;

import br.com.sgp.dto.SetorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends JpaRepository<SetorDTO, Long> {


}