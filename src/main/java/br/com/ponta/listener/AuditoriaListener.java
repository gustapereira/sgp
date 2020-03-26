package br.com.ponta.listener;

import br.com.sebrae.ponta.domain.Auditoria;
import org.springframework.stereotype.Service;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Service
public class AuditoriaListener {

    @PrePersist
    public void setCriacao(Auditable auditable) {
        Auditoria auditoria = auditable.getAuditoria();

        if (auditoria == null) {
            auditoria = new Auditoria();
            auditable.setAuditoria(auditoria);
        }

        auditoria.setDataCriacao(LocalDateTime.now());
    }

    @PreUpdate
    public void setAlteracao(Auditable auditable) {
        Auditoria auditoria = auditable.getAuditoria();

        if (auditoria == null) {
            auditoria = new Auditoria();
            auditable.setAuditoria(auditoria);
        }

        auditoria.setDataAlteracao(LocalDateTime.now());
    }
}
   