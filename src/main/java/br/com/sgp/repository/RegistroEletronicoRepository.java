package br.com.sgp.repository;

import br.com.sgp.domain.RegistroEletronico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroEletronicoRepository extends JpaRepository<RegistroEletronico, Long> {


}