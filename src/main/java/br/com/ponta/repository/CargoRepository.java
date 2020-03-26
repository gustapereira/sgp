package br.com.ponta.repository;

import br.com.ponta.domain.Cargo;
import br.com.ponta.domain.Empresa;
import br.com.ponta.domain.TypeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {


}