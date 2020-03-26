package br.com.ponta.repository;

import br.com.ponta.dto.CargoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CargoRepository extends JpaRepository<CargoDTO, Long> {

}