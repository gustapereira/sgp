package br.com.ponta.repository;

import br.com.ponta.dto.SetorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends JpaRepository<SetorDTO, Long> {


}