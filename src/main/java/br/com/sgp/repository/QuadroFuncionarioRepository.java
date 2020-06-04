package br.com.sgp.repository;

import br.com.sgp.domain.QuadroFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuadroFuncionarioRepository extends JpaRepository<QuadroFuncionario, Long> {

}