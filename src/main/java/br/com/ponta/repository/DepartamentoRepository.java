package br.com.ponta.repository;

import br.com.ponta.dto.DepartamentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoDTO, Long> {


}