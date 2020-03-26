package br.com.ponta.repository;

import br.com.ponta.dto.EmpresaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaDTO, Long> {


}