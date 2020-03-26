package br.com.ponta.listener;

import br.com.ponta.domain.Auditoria;

public interface Auditable {
 
    Auditoria getAuditoria();
 
    void setAuditoria(Auditoria auditoria);
}