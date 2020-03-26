package br.com.ponta.repository;

import br.com.ponta.domain.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UFRepository extends JpaRepository<UF, Long> {


}