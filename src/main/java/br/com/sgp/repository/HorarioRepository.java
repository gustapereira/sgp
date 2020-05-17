package br.com.sgp.repository;

import br.com.sgp.dto.HorarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<HorarioDTO, Long> {


}