package br.com.ponta.repository;

import br.com.ponta.dto.UFDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UFRepository extends JpaRepository<UFDTO, Long> {


}