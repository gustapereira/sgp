package br.com.ponta.repository;

import br.com.ponta.domain.RegistroEletronico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroEletronicoRepository extends JpaRepository<RegistroEletronico, Long> {


}