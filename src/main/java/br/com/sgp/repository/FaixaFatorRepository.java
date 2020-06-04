package br.com.sgp.repository;

import br.com.sgp.domain.FaixaFator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaixaFatorRepository extends JpaRepository<FaixaFator, Long> {

}