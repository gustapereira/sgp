package br.com.sgp.repository;

import br.com.sgp.dto.FuncionarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioDTO, Long> {


}