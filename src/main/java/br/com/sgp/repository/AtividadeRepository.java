package br.com.sgp.repository;

import br.com.sgp.domain.Empresa;
import br.com.sgp.domain.TypeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadeRepository extends JpaRepository<Empresa, Long> {

    @Query("select a from Empresa a " +
        "   inner join NoticiasAtividade na on na.atividade.id = a.id " +
        "   where na.noticias.id = :id ")
    List<Empresa> findAllByNews(@Param("id") Long id);

    @Query("select a from Empresa a " +
        "   inner join PropriedadeAtividade pa on pa.atividade.id = a.id " +
        "   where pa.propriedade.id = :id ")
    List<Empresa> findAllByProperty(@Param("id") Long id);

    @Query("select a from Empresa a " +
        "   inner join PragaAtividade pa on pa.atividade.id = a.id " +
        "   where pa.praga.id = :id ")
    List<Empresa> findAllByPraga(@Param("id") Long id);

    @Query("select a from Empresa a " +
        "   inner join PushNotificationAtividade pa on pa.atividade.id = a.id " +
        "   where pa.pushNotification.id = :id ")
    List<Empresa> findAllPush(@Param("id") Long id);

    @Query("select t from Empresa t where t.typeStatus = :type")
    List<Empresa> findByTypeStatus(@Param("type") TypeStatus typeStatus);
}