package br.com.sgp.repository;

import br.com.sgp.domain.Fator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatorRepository extends JpaRepository<Fator, Long> {

}