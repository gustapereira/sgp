package br.com.ponta.repository;

import br.com.ponta.dto.SecaoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecaoRepository extends JpaRepository<SecaoDTO, Long> {


}