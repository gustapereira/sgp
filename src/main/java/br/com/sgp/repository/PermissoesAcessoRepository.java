package br.com.sgp.repository;

import br.com.sgp.domain.PermissoesAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissoesAcessoRepository extends JpaRepository<PermissoesAcesso, Long> {


}