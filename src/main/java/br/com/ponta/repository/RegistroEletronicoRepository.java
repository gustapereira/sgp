package br.com.ponta.repository;

import br.com.ponta.dto.RegistroEletronicoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroEletronicoRepository extends JpaRepository<RegistroEletronicoDTO, Long> {


}