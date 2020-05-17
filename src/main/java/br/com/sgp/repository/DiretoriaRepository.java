package br.com.sgp.repository;

import br.com.sgp.domain.Diretoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretoriaRepository extends JpaRepository<Diretoria, Long> {


}