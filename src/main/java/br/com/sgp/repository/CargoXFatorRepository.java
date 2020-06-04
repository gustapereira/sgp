package br.com.sgp.repository;

import br.com.sgp.domain.CargoXFator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoXFatorRepository extends JpaRepository<CargoXFator, Long> {

}