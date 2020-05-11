package br.com.sgp.listener;

import br.com.sgp.domain.Auditoria;

public interface Auditable {
 
    Auditoria getAuditoria();
 
    void setAuditoria(Auditoria auditoria);
}