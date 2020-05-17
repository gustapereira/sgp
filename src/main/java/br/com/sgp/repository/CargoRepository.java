package br.com.sgp.repository;

import br.com.sgp.dto.CargoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<CargoDTO, Long> {

}